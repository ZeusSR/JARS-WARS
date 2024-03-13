package in.neuralnet.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import in.neuralnet.bo.EmployeeBO;

public class EmployeeDaoImpl implements IEmployeeDao {

	private static final String SQL_COUNT = "Select Count(1) FROM employee2";
	private static final String SQL_GET_BYID ="Select ename FROM employee2 WHERE eid =?";
	private static final String SQL_GETALL_ID = "Select * FROM employee2 WHERE eid =?";
	private static final String SQL_GETBT_DESG = "Select * FROM employee2 WHERE eaddress IN (?,?)";
	private static final String SQL_INSERT = "INSERT INTO employee2(ename,eaddress,salary) VALUES (?, ?, ?)";
	private static final String SQL_UPADTE = "UPDATE employee2 SET salary = salary + ? WHERE eaddress =?";
	private JdbcTemplate template;
	
	
	
	@Override
	public String toString() {
		return "EmployeeDaoImpl [template=" + template + "]";
	}



	public EmployeeDaoImpl(JdbcTemplate template) {
		this.template = template;
	}



	@Override
	public int fetchEmpscount() {

		System.out.println(template);
		return template.queryForObject(SQL_COUNT, Integer.class);
		
		
		
	}



	@Override
	public String getEmployeeNameByNo(int eno) {
		
		return template.queryForObject(SQL_GET_BYID, String.class,eno);
	}



	@Override
	public Map<String, Object> getEmployeeDetailsByNo(int eno) {
		
		return template.queryForMap(SQL_GETALL_ID,eno);
	}



	@Override
	public List<Map<String, Object>> getEmployeeDeatilsByDesignation(String desg1, String desg2) {
		return template.queryForList(SQL_GETBT_DESG, desg1,desg2);
	}



	@Override
	public int insertEmp(String ename, String eaddress, double salary) {
		return template.update(SQL_INSERT, ename,eaddress,salary);
	}



	@Override
	public int addBonusToEmpByDesg(String desg, double bonus) {
		
		return template.update(SQL_UPADTE,bonus,desg);
	}



//	@Override
//	public List<EmployeeBO> getEmployeeByAddress(String addr1, String addr2) {
//		
//		return template.query(SQL_GETBT_DESG,new EmployeeRowMapper(),addr1,addr2);
//		
//	}
//		private static class EmployeeRowMapper implements RowMapper<EmployeeBO>
//		{
//
//			@Override
//			public EmployeeBO mapRow(ResultSet rs, int rowNum) throws SQLException {
//				
//				EmployeeBO bo = null;
//				bo = new EmployeeBO();
//				bo.setInt_id(rs.getInt(1));
//				bo.setS_address(rs.getString(2));
//				bo.setS_name(rs.getString(3));
//				bo.setD_salary(rs.getFloat(4));
//				
//				return bo;
//			}
	
	@Override
	public List<EmployeeBO> getEmployeeByAddress(String addr1, String addr2) {
		final List<EmployeeBO> listBo = new ArrayList<EmployeeBO>();
		 template.query(SQL_GETBT_DESG,new RowCallbackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				System.out.println(
						"StudentDaoImpl.fetchStudentByCitites(...).new RowCallbackHandler() {...}.processRow()");
				
				EmployeeBO bo = null;
				bo = new EmployeeBO();
				
				bo.setInt_id(rs.getInt(1));
				bo.setS_address(rs.getString(2));
				bo.setS_name(rs.getString(3));
				bo.setD_salary(rs.getFloat(4));
				
				listBo.add(bo);
			
		}},addr1,addr2);
		 
		 return listBo;
		
	}
			
		
	

}

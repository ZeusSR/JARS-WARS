package in.neuralnet.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

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

}

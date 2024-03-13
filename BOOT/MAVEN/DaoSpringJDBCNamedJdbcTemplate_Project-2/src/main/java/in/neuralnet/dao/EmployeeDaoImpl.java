package in.neuralnet.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import in.neuralnet.bo.EmployeeBO;

@Repository
public class EmployeeDaoImpl implements IEmployeeDao {

	private static final String GET_SQL = "Select eid,eaddress,ename,salary FROM employee2 WHERE eaddress IN (:desg1,:desg2,:desg3)";
	private static final String SQL_INSERT = "INSERT INTO employee2(ename,eaddress,salary) VALUES (:ename, :eaddress,:salary)";
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	@Override
	public List<EmployeeBO> fetchEmployeesByDesg(String desg1, String desg2, String desg3) {
		
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("desg1", desg1);
		map.addValue("desg2", desg2);
		map.addValue("desg3", desg3);
		
		return template.query(GET_SQL, map,
				// lambda Expression of ResultSetExtractor===>extractData(ResultSet rs)
				rs->{
					
					List<EmployeeBO> bo = new ArrayList<EmployeeBO>();
				   while(rs.next())
				   {
					   EmployeeBO empbo = new EmployeeBO();
					   empbo.setInt_id(rs.getInt("eid"));
					   empbo.setS_address(rs.getString("eaddress"));
					   empbo.setS_name(rs.getString("ename"));
					   empbo.setD_salary(rs.getDouble("salary"));
					   
					   bo.add(empbo);
				   }
					
					return bo;
				});
	}

	@Override
	public int registerEmployee(EmployeeBO bo) {
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("eaddress", bo.getS_address());
		map.addValue("ename", bo.getS_name());
		map.addValue("salary", bo.getD_salary());
		return template.update(SQL_INSERT, map);
	}

}

package in.neuralnet.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import in.neuralnet.bo.EmployeeBO;

@Repository
public class EmployeeDaoImpl implements IEmployeeDao {

	private static final String GET_SQL = "Select eid,eaddress,ename,salary FROM employee2 WHERE eaddress IN (:desg1,:desg2,:desg3)";
	private static final String SQL_INSERT = "INSERT INTO employee2(ename,eaddress,salary) VALUES (:ename, :eaddress,:salary)";
	private static final String GET_FUNCPRO = "SELECT * FROM func_get_employees_by_address(:address1, :address2)";
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
//	@Autowired
//	private DataSource datasource;
	
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

	@Override
	public List<EmployeeBO> fetchEmployeesByAddr(String addr1, String addr2) {
		
	
	/*
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(datasource)
			    .withProcedureName("func_get_employees_by_address").returningResultSet("emp", new BeanPropertyRowMapper<EmployeeBO>(EmployeeBO.class)); // Specify your stored procedure name

			Map<String, Object> inParams = new HashMap<>();
			inParams.put("address1", addr1);
			inParams.put("address2", addr2);

			Map<String, Object> out = jdbcCall.execute(inParams); 
			System.out.println(out);
			
			@SuppressWarnings("unchecked")
			List<EmployeeBO> bo = new ArrayList<EmployeeBO>();
			 bo = (List<EmployeeBO>) out.get("emp");
			
			System.out.println(bo); */
		
		Map<String, Object> inParams = new HashMap<>();
		inParams.put("address1", addr1);
		inParams.put("address2", addr2);
			
		List<EmployeeBO> bo =template.query(GET_FUNCPRO, inParams, new BeanPropertyRowMapper<>(EmployeeBO.class));

		
			
			return bo;
	}

}

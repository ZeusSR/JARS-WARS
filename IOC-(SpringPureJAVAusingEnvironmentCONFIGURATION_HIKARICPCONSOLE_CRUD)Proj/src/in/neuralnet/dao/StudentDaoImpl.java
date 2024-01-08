package in.neuralnet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import in.neuralnet.bo.StudentBO;

@Repository("dao")
public class StudentDaoImpl implements IStudentdao {

	@Autowired
//	@Qualifier("hikariDataSource")
	private DataSource dataSource;
	
	private final static String insert = "INSERT INTO public.\"SPRING_STUDENT\"(name, \"Sports\", address, \"Amount\")VALUES (?, ?, ?, ?);";
	
	private static String select = "SELECT reg_id, name, \"Sports\", address, \"Amount\" FROM public.\"SPRING_STUDENT\"";
	
	private static String select_byid = "SELECT reg_id, name, \"Sports\", address, \"Amount\" FROM public.\"SPRING_STUDENT\" WHERE reg_id= ?";
	
	private final static String update = "UPDATE public.\"SPRING_STUDENT\" SET  name=?, \"Sports\"=?, address=? WHERE reg_id = ?";
	
	private final static String delete = "DELETE FROM public.\"SPRING_STUDENT\"	WHERE  reg_id = ?";
	
	@Override
	public String saveStudent(StudentBO student) {

		int rowcount = 0;
		
		try (Connection connection = dataSource.getConnection()) {
		
			PreparedStatement ps = connection.prepareStatement(insert);
			ps.setString(1, student.getName() );
			ps.setString(2, student.getSports());
			ps.setString(3, student.getAddress());
			ps.setFloat(4, student.getAmount());
			
			rowcount = ps.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowcount == 1 ? "success" : "Record insertion failed";
	}

	@Override
	public List<StudentBO> findall() {

		List<StudentBO> bo = null; 
		try (Connection connection = dataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(select);
				ResultSet rs = ps.executeQuery();) {
			
//			PreparedStatement ps = connection.prepareStatement(select);
//			ResultSet rs = ps.executeQuery();
			
			 
			 bo = new ArrayList<StudentBO>();
			 
			 while(rs.next())
			 {
				 StudentBO BO = new StudentBO();
				 BO.setReg_id(rs.getInt(1));
				 BO.setName(rs.getString(2));
				 BO.setSports(rs.getString(3));
				 BO.setAddress(rs.getString(4));
				 BO.setAmount(rs.getFloat(5));
				 
				 bo.add(BO);
			 }
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return bo;
	}

	@Override
	public StudentBO findById(Integer reg_id) {
		
		StudentBO bo = null;
		try (Connection connection = dataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(select_byid);
				)
	{
			ps.setInt(1, reg_id);
			ResultSet rs = ps.executeQuery();
		     bo = new StudentBO();
		    while(rs.next())
		    {
		    	bo.setReg_id(rs.getInt(1));
		    	bo.setName(rs.getString(2));
		    	bo.setSports(rs.getString(3));
		    	bo.setAddress(rs.getString(4));
		    	bo.setAmount(rs.getFloat(5));
		    }
		
		
	} catch (SQLException e) {
		e.printStackTrace();
		
	}
		return bo;
	}

	@Override
	public String updateById(StudentBO student) {
		int rowcount = 0;
		try (Connection connection = dataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(update);
				)
	{
			ps.setString(1, student.getName() );
			ps.setString(2, student.getSports());
			ps.setString(3, student.getAddress());
			ps.setInt(4, student.getReg_id());
		
			 rowcount = ps.executeUpdate();
			
	} catch (SQLException e) {
		e.printStackTrace();
		
	}		
		return rowcount == 1 ? "success" : "Record insertion failed";
	}

	@Override
	public String deleteById(Integer reg_id) {
		
		int rowcount = 0;
		try (Connection connection = dataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(delete);
				)
	{
			ps.setInt(1, reg_id);
			 rowcount = ps.executeUpdate();
				
		} catch (SQLException e) {
			e.printStackTrace();
			
		}		
			return rowcount == 1 ? "success" : "failure";
	}



}

package in.neuralnet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import in.neuralnet.BO.CustomerBO;

public class CustomerPGSQLDAOImp implements ICustomerDAO {

	static
	{
		System.out.println("CustomerPGSQLDAOImp.class Loading..");
	}
	int res = 0;
	private static final String CUSTOMER_INSERT_QUERY = "INSERT INTO public.\"SPRING_CUSTOMER\"(\r\n"
		+" \"CNAME\", \"CADDR\", \"PAMNT\", \"INTRAMNT\")\r\n"
			+ "	VALUES (?, ?, ?, ?);";
	private DataSource dataSource;
	
	
	
	public CustomerPGSQLDAOImp(DataSource dataSource) {
		super();
		
		System.out.println("CustomerPGSQLDAOImp: 1 parm constructor.....");
		this.dataSource = dataSource;
	}



	@Override
	public int insert(CustomerBO bo) {

		try (Connection connection = dataSource.getConnection()) {
			
			System.out.println(bo);
			
			PreparedStatement pstmt = connection.prepareStatement(CUSTOMER_INSERT_QUERY);
			
			pstmt.setString(1, bo.getCustomerName());
			pstmt.setString(2, bo.getCustomerAddress());
			pstmt.setFloat(3, bo.getPamt());
			pstmt.setFloat(4, bo.getInterestAmt());
			
			 res = pstmt.executeUpdate();
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

}

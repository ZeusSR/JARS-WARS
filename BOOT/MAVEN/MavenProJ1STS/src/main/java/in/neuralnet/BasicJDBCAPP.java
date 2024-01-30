package in.neuralnet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BasicJDBCAPP {

	public static void main(String[] args) throws SQLException {
		
		
		//2.Setting-up connection
		String url = "jdbc:postgresql://localhost:5433/in_db_instance";
		String user = "postgres";
		String password="Csm#5518";
		Connection connection = DriverManager.getConnection(url,user , password);
		
		//3.Creation of statement object(to move to the location using connection)
		Statement statement = connection.createStatement();
		
		//4.Using statement object to execute the query & store in resultset obj.
        String script ="Select sid,address from student";
		ResultSet resultset = statement.executeQuery(script);
		
		//5.process the result to get the data
		System.out.println("sid\tsaddress");
		while(resultset.next())
		{
			Integer sid = resultset.getInt(1); 
			String saddress = resultset.getString(2);
			System.out.println(sid+ "\t" +saddress);
		}
		
		//6.Closing the resources used
		resultset.close();
		statement.close();
		connection.close();
	}


   }




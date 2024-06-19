package practice_sleneium;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class InsertDataIntoDB {
	public static void main(String[] args) throws Throwable {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/canadabatch","root","@Somsuvro98");
		Statement state = conn.createStatement();
		String query="insert into mytable(firstname,lastname,gender)values('Virat','Kohli','male')";
		int result = state.executeUpdate(query);
		if(result==1)
		{
			System.out.println("Data updated");
		}
		else
		{
			System.out.println("Data not updated");
		}
		conn.close();
		
		
	}

}

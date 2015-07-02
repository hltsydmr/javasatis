package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Functions {

	public static Connection getConnection() throws SQLException{
		try {
			
			String dbUrl = "jdbc:sqlserver://hltsydmr2.c2ca7bnqthm4.us-west-2.rds.amazonaws.com:1433;databaseName=hltsydmr;user=hltsydmr2;password=hltsydmr2";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(dbUrl);
			return conn;
		} catch (Exception e) {
			System.out.println("Connection ERROR!");
			return null;
		}
	}
	
}

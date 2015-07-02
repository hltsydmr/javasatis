package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Functions {

	public static Connection getConnection() throws SQLException{
		try {
			
			String dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=SOYDEMIR;user=sa;password=123456";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(dbUrl);
			return conn;
		} catch (Exception e) {
			System.out.println("Connection ERROR!");
			return null;
		}
	}
	
}

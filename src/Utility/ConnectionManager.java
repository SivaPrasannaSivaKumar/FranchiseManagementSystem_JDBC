package Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	public static Connection getConnection() throws ClassNotFoundException {
		String DRIVER = "com.mysql.jdbc.Driver";
		String URl = "jdbc:mysql://localhost:3306/Fms";
		String USERNAME = "root";
		String PASSWORD = "Prasann@08";
		Class.forName(DRIVER);
		try {
			Connection conn = DriverManager.getConnection(URl, USERNAME, PASSWORD);
			if(conn != null) {
				return conn;
			}
		} catch (SQLException e) {
			System.out.println("😕 Unable to establish the connection");
			e.printStackTrace();
		}
		return null;
	}
}

package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class MYSQL {
	
	private static  volatile MYSQL instance; 
	
	private static String url = "jdbc:mysql://localhost:3306/job_database";
	private static String username = "root";
	private static String password = "";
	
	private static MYSQL getInstance() {
		if (instance == null) {
			synchronized (MYSQL.class) {
				if (instance == null) {
					instance = new MYSQL();
				}
			}
		}
		return instance;
	}
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static void main (String[] args) {
		Connection connection = MYSQL.getConnection();
		if (connection != null) {
			System.out.println("Connection established successfully!");
		} else {
			System.out.println("Failed to establish connection.");
		}
	}
	

}

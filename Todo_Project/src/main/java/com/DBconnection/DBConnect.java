package com.DBconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	private static String jdbcURL = "jdbc:mysql://localhost:3306/todo?useSSL=false";
	private static String jdbcUsername = "root";
	private static String jdbcPassword = "111@Gudu";
	
	public static Connection getCon() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return conn;
	}

}

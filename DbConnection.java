package com.ieee.servlet;



import java.sql.*;


public class DbConnection {

	static Connection con;
	public static Connection getConnections() {
		try {			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/summarization","root","root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}

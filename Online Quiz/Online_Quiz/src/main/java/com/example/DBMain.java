package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBMain {
	public static final String DRIVER_NAME="com.mysql.jdbc.Driver";
	public static final String URL_NAME="jdbc:mysql://localhost:3306/quiz";
	public static final String USER_NAME="root";
	public static final String PASS_WORD="Ramya2001@13";
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER_NAME);
		Connection conn=DriverManager.getConnection(URL_NAME,USER_NAME,PASS_WORD);
		return conn;
	}
}
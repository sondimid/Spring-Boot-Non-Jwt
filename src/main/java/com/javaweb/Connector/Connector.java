package com.javaweb.Connector;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
	static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
	static final String USER = "root";
	static final String PASSWORD = "123456789a";
	
	public static Connection getConnect() {
		Connection connection = null;
		try{
			connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}

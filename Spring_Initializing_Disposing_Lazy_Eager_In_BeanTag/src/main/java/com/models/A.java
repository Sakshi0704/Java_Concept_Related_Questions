package com.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class A {
	
	private String driverName;
	private String url;
	private String username;
	private String password;
	
	
	private Connection conn;
	
	
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public void init() {
		
	    System.out.println("inside init method of class A where Connection will be established");
		
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url,username,password);
		} catch (ClassNotFoundException | SQLException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void insertStudentRecord() {
		
		System.out.println("connection obj is ready to insert to insert into the table "+conn);
	}
	
	public void tearDown() {
		 System.out.println("inside tearDown method");
		try {
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

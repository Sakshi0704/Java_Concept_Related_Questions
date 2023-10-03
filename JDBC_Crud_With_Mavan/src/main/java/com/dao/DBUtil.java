package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtil {
	
	public static Connection getConnection() throws SQLException {
		
			//Class.forName("");
		
			ResourceBundle rs = ResourceBundle.getBundle("DBDetails");
			
			Connection conn = DriverManager.getConnection(rs.getString("url"),rs.getString("username"),rs.getString("password"));
			
			return conn;
			
	}
	
	public static void closeConnection(Connection conn) throws SQLException {
		if(conn != null) {
			conn.close();
		}
	}
	
	
	public static boolean isResultSetExsit(ResultSet rs) throws SQLException {
		if(!rs.isBeforeFirst() && rs.getRow()==0) {
			return false;
		}
		return true;
	}
	
	
	
}

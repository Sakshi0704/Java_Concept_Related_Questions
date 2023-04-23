package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pre_evaluation_db","root","root");
		
	
		return conn;
	}
	
	
	public static void closeConnection(Connection conn) throws SQLException {
		if(conn!=null) {
			conn.close();
		}
	}
	
	
	public static boolean resultSetIsEmpty(ResultSet rs) throws SQLException {
		if(!rs.isBeforeFirst()&&rs.getRow()==0) {
			return true;
		}
		return false;
	}
	
	
}

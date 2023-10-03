package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtils {
	
	public static Connection getConnection()  {
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   // it will throw the exception ClassNotFoundException
		
		// going to use properties of dbdetails.properties file ...
		ResourceBundle rb = ResourceBundle.getBundle("DbDetails");
		
//		rb.getString("url");
//		rb.getString("username");
//		rb.getString("password");
	
		
		// step-2: ( for taking the connection )
		// public static Connection getConnection(String url, String name, String password) throws SQLException
		
		Connection conn=null;
		try {
			conn = DriverManager.getConnection(rb.getString("url"),rb.getString("username"),rb.getString("password"));
			//return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		System.out.println("Connection established successfully");
		
		return conn;
     //conn.close();
	}
	static void closeConnection(Connection conn) throws SQLException{
		if(conn!=null) {
			conn.close();
		}
	}
	/**
	 * check whether the ResultSet is empty or not
	 * @param rs: ResultSet to be checkedc for empty 
	 * @return true if Resultset is Empty, false otherwise
	 * @throws SQLException
	 */
	static boolean isResultSetEmpty(ResultSet rs) throws SQLException{
		if(!rs.isBeforeFirst() && rs.getRow() == 0) {
			return true;
		}
		return false;
	}

}

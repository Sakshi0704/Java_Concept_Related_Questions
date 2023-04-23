package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.exceptions.SomethingWentWrong;
import com.model.Jobseeker;
import com.util.DBUtil;

public class ConsultancyDAOJdbcImpl implements ConsultancyDAO {

	public Jobseeker findJobseekerById(int id) throws SomethingWentWrong {
		
		Connection conn = null;
		
		Jobseeker js = null;
		
		
		try {
			
			conn = DBUtil.getConnection();
			
			String query = "select * from where id = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(DBUtil.resultSetIsEmpty(rs)) {
				throw new SomethingWentWrong("No Record Found");
			}
			//int id, String email, String address, String modNo, String category, int experience
			if(rs.next()) {
				js =  new Jobseeker(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));
			}
			
			
		}catch(Exception ex) {
			throw new SomethingWentWrong(ex.getMessage());
		}finally {
			try {
				DBUtil.closeConnection(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return js;
	}

	public String saveJobseeker(Jobseeker jobseeker) throws SomethingWentWrong {

		Connection conn = null;
		String result = "Unable To Save The Record";
		
		try {
			
			conn = DBUtil.getConnection();
			
			String query = "insert into jobseeker (id,email,address,modNo,category,experience) values (?,?,?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1,jobseeker.getId());
			ps.setString(2, jobseeker.getEmail());
			ps.setString(3, jobseeker.getAddress());
			ps.setString(4, jobseeker.getModNo());
			ps.setString(5, jobseeker.getCategory());
			ps.setInt(6, jobseeker.getExperience());
			
			
			int n = ps.executeUpdate();
			
			if(n==0) {
				throw new SomethingWentWrong("Unable to save record please give the correct input");
			}
			//int id, String email, String address, String modNo, String category, int experience
			
			result = "Save the record successfully";
			
		}catch(Exception ex) {
			throw new SomethingWentWrong(ex.getMessage());
		}finally {
			try {
				DBUtil.closeConnection(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	  return result;
	}

	public String deleteJobseekerById(int id) throws SomethingWentWrong {
		Connection conn = null;
		String result = "Unable To Delete The Record";
		
		try {
			
			conn = DBUtil.getConnection();
			
			String query = "delete from jobseeker where id = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1,id);
			
			int n = ps.executeUpdate();
			
			if(n==0) {
				throw new SomethingWentWrong("there is no such record available");
			}
			//int id, String email, String address, String modNo, String category, int experience
			
			result = "Delete the record successfully";
			
		}catch(Exception ex) {
			throw new SomethingWentWrong(ex.getMessage());
		}finally {
			try {
				DBUtil.closeConnection(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	  return result;
	}

	public String updateJobseekerExperience(int id, int experience) throws SomethingWentWrong {
		Connection conn = null;
		String result = "Unable To Update The Record";
		
		try {
			
			conn = DBUtil.getConnection();
			
			String query = "select experience from jobseeker where id = ?";
		
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1,id);
			
			ResultSet rs = ps.executeQuery();
			
			if(DBUtil.resultSetIsEmpty(rs)) {
				throw new SomethingWentWrong("there is no such record available");
			}
			
			int preExperience = 0;
			if(rs.next()) {
				preExperience = rs.getInt(1);
				//"update jobseeker set experience = experience + ? where id = ?"
			}
			query = "update jobseeker set experience =  ? where id = ?";
			
			ps = conn.prepareStatement(query);
			
			
			ps.setInt(1,preExperience+experience);
			ps.setInt(2,id);
			
			int n = ps.executeUpdate();
			
			if(n==0) {
				throw new SomethingWentWrong("unable to update");
			}
			//int id, String email, String address, String modNo, String category, int experience
			
			result = "Update the record successfully";
			
		}catch(Exception ex) {
			throw new SomethingWentWrong(ex.getMessage());
		}finally {
			try {
				DBUtil.closeConnection(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	  return result;
	}

}

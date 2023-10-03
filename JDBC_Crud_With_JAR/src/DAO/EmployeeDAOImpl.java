package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import Entity.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public void addEmployeeInData(Employee emp) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBUtils.getConnection();
			
			String querry="insert into employee (eid, name, salary, joining_date) values (?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(querry);
			ps.setString(1,emp.getId());
			ps.setString(2, emp.getName());
			ps.setDouble(3, emp.getSalary());
			ps.setDate(4,Date.valueOf(emp.getJoining_date()));
			if(ps.executeUpdate()>0){
				System.out.println("Updated successfully");
			}
		}catch(Exception ex){
			throw new Exception("Unable to insert the record now, try again later");
		}finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		
		
		
	}

	@Override
	public void viewEmployeeInData(String id) throws Exception {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void updateEmployeeInData(Employee emp, String eid) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBUtils.getConnection();
			String query="update Employee set name=? ,salary=? , joining_date=? where eid=? ";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1,emp.getName() );
			ps.setDouble(0, emp.getSalary());
			ps.setDate(3, Date.valueOf(emp.getJoining_date()));
			ps.setString(4, emp.getId());
			ps.executeUpdate();
			
		}catch(Exception e) {
			throw new Exception("unable to update");
		}finally {
			try {
				DBUtils.closeConnection(conn);
				
			}catch(SQLException e) {
				System.out.println(e);
			}
		}
		
	}

	@Override
	public void deleteEmployeeInData(String eid) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn = DBUtils.getConnection();
			String query = "delete from employee where eid LIKE ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1,eid);
			
			ps.executeUpdate();
			
		}catch(Exception e) {
			throw new Exception("unable to delete");
		}finally {
			try {
				DBUtils.closeConnection(conn);
				
			}catch(SQLException e) {
				System.out.println(e);
			}
		}
		
	}

	@Override
	public List<Employee> searchEmployeeByjoiningDateInData(LocalDate dt1, LocalDate dt2) {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.Employee;
import com.exception.EmployeeException;

public class EmpDaoImpl implements EmpDao {

	public String registerEmployee(Employee employee) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		if(employee==null) {
			sb.append("please provide the proper object");
		}
		
		// DML --> insert / delete / update
		
		Connection conn = null;
		
		try {
			// Connection declare 
			// createStatement() -- prepareStatment(query) // factory methods
			// PreparedStatment --> excuteUpdate() // excuteQuery();
			
			conn = DBUtil.getConnection();
			String query = "insert into employee (empId,name,salary) values (?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(query);
		
			ps.setInt(1,employee.getEmpId());
			ps.setString(2, employee.getName());
			ps.setInt(3, employee.getSalary());
			
			int n = ps.executeUpdate();
			if(n==0) {
				throw new EmployeeException("Can not add this data");
			}
			
			sb.append("employee added seccussfully");
			
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}finally {
				try {
					DBUtil.closeConnection(conn);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return sb.toString();
	}

	public Employee getEmployeeById(int empId) throws EmployeeException {
		// TODO Auto-generated method stub
		
		// Connection - query(string) -- PreparedStatement -- ResultSet -- 
		Connection conn = null;
		Employee emp = null;
		try {
			
			conn = DBUtil.getConnection();
			
			String query = "select * from employee where empId = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1,empId);
			
			ResultSet rs = ps.executeQuery();
			
			if(!DBUtil.isResultSetExsit(rs)) {
				throw new EmployeeException("Employee does not exist with given id");
			}
			
			emp = new Employee();
			while(rs.next()) {
				emp.setEmpId(rs.getInt(2));
				emp.setName(rs.getString(3));
				emp.setSalary(rs.getInt(4));
			}
			
		}catch(Exception ex) {
			throw new EmployeeException(ex.getMessage());
		}finally {
			try {
				DBUtil.closeConnection(conn);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				throw new EmployeeException(e.getMessage());
			}
		}
		
		return emp;
	}

	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		List<Employee> emps = null;
		try {
			
			conn = DBUtil.getConnection();
			
			String query = "select * from employee";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			
			ResultSet rs = ps.executeQuery();
			
			if(!DBUtil.isResultSetExsit(rs)) {
				throw new EmployeeException("No Employees in Record");
			}
			
			emps = new ArrayList<Employee>();
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEmpId(rs.getInt(2));
				emp.setName(rs.getString(3));
				emp.setSalary(rs.getInt(4));
				emps.add(emp);
			}
			
		}catch(Exception ex) {
			System.out.println(ex.getStackTrace());
		}finally {
			try {
				DBUtil.closeConnection(conn);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.getStackTrace();
			}
		}
		
		return emps;
	}

	public String deleteEmployeeById(int empId) throws EmployeeException {
		
		StringBuilder sb = new StringBuilder();
		
		Connection conn = null;
		
		try {
			// Connection declare 
			// createStatement() -- prepareStatment(query) // factory methods
			// PreparedStatment --> excuteUpdate() // excuteQuery();
			
			conn = DBUtil.getConnection();
			String query = "delete from employee where empId = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
		
			ps.setInt(1,empId);
		
			int n = ps.executeUpdate();
			if(n==0) {
				sb.append("Unable to delete this data");
			}
			
			sb.append("Employee deleted seccussfully");
			
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}finally {
				try {
					DBUtil.closeConnection(conn);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return sb.toString();
	}

	public String giveBonusToEmployee(int empId, int amount) throws EmployeeException {
		
StringBuilder sb = new StringBuilder();
		
		Connection conn = null;
		
		try {
			// Connection declare 
			// createStatement() -- prepareStatment(query) // factory methods
			// PreparedStatment --> excuteUpdate() // excuteQuery();
			
			conn = DBUtil.getConnection();
			String query = "update employee set salary = salary + ? where empId = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, amount);
			ps.setInt(2,empId);
		
			int n = ps.executeUpdate();
			if(n==0) {
				//throw new EmployeeException("Can not update this data");
				sb.append("Can not update this data");
			}
			
			sb.append("employee updated seccussfully");
			
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}finally {
				try {
					DBUtil.closeConnection(conn);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return sb.toString();
		
	}

}

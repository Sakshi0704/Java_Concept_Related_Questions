package DAO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import Entity.Employee;

public interface EmployeeDAO {
	public void addEmployeeInData(Employee emp) throws Exception ;
	public void viewEmployeeInData(String id)throws Exception;
	public void updateEmployeeInData(Employee emp,String eid) throws Exception;
	public void deleteEmployeeInData(String id) throws Exception;
	public List<Employee> searchEmployeeByjoiningDateInData(LocalDate dt1,LocalDate dt2);
	
	
	
	
}

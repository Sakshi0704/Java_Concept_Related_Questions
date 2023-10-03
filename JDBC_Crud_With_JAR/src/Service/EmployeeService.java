package Service;

import java.time.LocalDate;

import java.util.*;

import Entity.Employee;

public interface EmployeeService {
	 
	public String addEmployee(Employee emp);
	public Employee viewEmployee(String id);
	public String updateEmployee(Employee emp,String eid);
	public String deleteEmployee(String id);
	public List<Employee> searchEmployeeByJoiningDateRange(LocalDate dt1,LocalDate dt2);
	

}

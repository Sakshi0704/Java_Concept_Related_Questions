package com.dao;

import java.util.List;

import com.dto.Employee;
import com.exception.EmployeeException;

public interface EmpDao {

	public String registerEmployee(Employee employee);
	
	public Employee getEmployeeById(int empId)throws EmployeeException;
	
	public List<Employee> getAllEmployee();
	
	public String deleteEmployeeById(int empId)throws EmployeeException;
	
	public String giveBonusToEmployee(int empId, int amount)throws EmployeeException;
	
}

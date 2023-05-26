package com.masai.service;

import java.util.List;

import com.masai.exception.EmployeeNotFoundException;
import com.masai.model.Employee;


public interface EmployeeService {

	public Employee addEmployee(Employee emp);
	
	public Employee updateEmployee(Integer empId, Employee emp) throws EmployeeNotFoundException;
	
	public String deleteEmployee(Integer empId) throws EmployeeNotFoundException;
	
	public Employee getAEmployee(Integer empId) throws EmployeeNotFoundException;

	public List<Employee> getEmployees();
	
	
}

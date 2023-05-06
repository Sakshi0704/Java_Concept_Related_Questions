package com.sakshi.service;

import java.util.List;

import com.sakshi.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();
	
	void saveEmployee(Employee employee);
	
	
}

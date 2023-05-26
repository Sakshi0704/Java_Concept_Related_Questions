package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.EmployeeNotFoundException;
import com.masai.model.Employee;
import com.masai.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public Employee addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		
		Employee employee = employeeRepo.save(emp);
		
		return employee;
	}

	@Override
	public Employee updateEmployee(Integer empId, Employee emp) throws EmployeeNotFoundException {
		
	 Employee existEmp = employeeRepo.findById(empId)
			 .orElseThrow(() -> new EmployeeNotFoundException("Employee does not exists"));
		
	 	if(emp.getFirstName()!=null) {
	 		existEmp.setFirstName(emp.getFirstName());
	 	}
	    
	 	if(emp.getLastName()!=null) {
	 		 existEmp.setLastName(emp.getLastName());
	 	}
	   
	 	if(emp.getDob()!=null) {
	 		existEmp.setDob(emp.getDob());
	 	}
	    
	 	if(emp.getEmail()!=null) {
	 	    existEmp.setEmail(emp.getEmail());
	 	}
	   
	 	if(emp.getAddress()!=null) {
	 		existEmp.setAddress(emp.getAddress());
	 	}
	    
	 	if(emp.getPhoneNo()!=null) {
	 		existEmp.setPhoneNo(emp.getPhoneNo());
	 	}
	   
	 	if(emp.getPosition()!=null) {
	 		existEmp.setPosition(emp.getPosition());
	 		
	 	}
	    
	    
	 // here save() method will work as save or merge with respect to id fields.
	    employeeRepo.save(existEmp);
	    
		return existEmp;
	}

	@Override
	public String deleteEmployee(Integer empId) throws EmployeeNotFoundException {
		
		 Employee existEmp = employeeRepo.findById(empId).orElseThrow(() -> new EmployeeNotFoundException("Employee does not exist of empId "+empId));
		 employeeRepo.delete(existEmp);
		 
		return "Delete Successfully" + existEmp;
	}

	@Override
	public Employee getAEmployee(Integer empId) throws EmployeeNotFoundException {
		
		Employee existEmp = employeeRepo.findById(empId).orElseThrow(() -> new EmployeeNotFoundException("Employee does not exist of empId "+ empId));
		
		return existEmp;
	}

	@Override
	public List<Employee> getEmployees() {
		
		List<Employee> empList = employeeRepo.findAll();
		if(empList == null) {
			new EmployeeNotFoundException("No Record Found");
		}
		
		return empList;
	}

}

package com.ui;

import java.util.List;
import java.util.Scanner;

import com.dao.EmpDao;
import com.dao.EmpDaoImpl;
import com.dto.Employee;
import com.exception.EmployeeException;

public class UIEmployeeFunction {
	
	private EmpDao empDao;
	
	public UIEmployeeFunction() {
		empDao = new EmpDaoImpl();
	}
	
	public void registerEmployee(Scanner sr) {
		Employee employee = new Employee();
		System.out.print("Enter the employee details \n Enter empId: ");
		employee.setEmpId(sr.nextInt());
		System.out.print("Enter empName : ");
		employee.setName(sr.next());
		System.out.print("Enter empSalary : ");
		employee.setSalary(sr.nextInt());
		
		String str = empDao.registerEmployee(employee);
		
		System.out.println(str);
		
	}
	
	public void getEmployeeById(Scanner sr){
		
		System.out.print("Enter empId to get particuler employee : ");
		int empId = sr.nextInt();
		try {
			Employee emp = empDao.getEmployeeById(empId);
			System.out.println(emp);
		}catch(EmployeeException ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	
	public void getAllEmployee() {
		System.out.println("Get All Employees from Record");
		List<Employee> list = empDao.getAllEmployee();
		
		list.forEach(e -> System.out.println(e));
		
	}
	
	public void deleteEmployeeById(Scanner sr){
		System.out.print("Enter the empId who you want to remove from record : ");
		int empId = sr.nextInt();
		try {
			String str = empDao.deleteEmployeeById(empId);
			System.out.println(str);
		}catch(EmployeeException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void giveBonusToEmployee(Scanner sr){
		System.out.print("Enter empId : ");
		int empId = sr.nextInt();
		System.out.print("Enter amount of bonus : ");
		int ammount = sr.nextInt();
		try {
			String str = empDao.giveBonusToEmployee(empId, ammount);
			System.out.println(str);
		}catch(EmployeeException ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	
}

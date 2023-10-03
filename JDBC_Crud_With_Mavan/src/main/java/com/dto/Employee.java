package com.dto;

public class Employee {

	private int empId;
	private String name;
	private int salary;
	
	
	public int getEmpId() {
		return empId;
	}
	
	public String getName() {
		return name;
	}
	
	public int getSalary() {
		return salary;
	}
	
	
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public String toString() {
		return "empId : "+empId+" empName : "+name+" empSalary : "+salary;
	}
}

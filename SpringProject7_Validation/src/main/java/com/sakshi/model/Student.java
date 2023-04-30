package com.sakshi.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Student {

	@Min(value = 100 , message = "{roll.invalid}") // @Min(value = 100,message = "Roll number is invalid")
	private Integer roll;
	
	@NotNull(message = "Name is Mandatory")
	@Size(min = 3,max = 10, message = "Name length should be 3 to 10") // @Size(min=3,max=10,message="Name length should be 3 to 10)
	private String name;
	
	@NotNull(message = "Address is Mandatory")
	@NotBlank(message = "Address not be blank")
	@NotEmpty(message = "Address should not be empty")
	private String address;
	

	private Integer marks;
	
	
	public Student() {
		super();
	}


	public Student(Integer roll, String name, String address, Integer marks) {
		super();
		this.roll = roll;
		this.name = name;
		this.address = address;
		this.marks = marks;
	}


	public Integer getRoll() {
		return roll;
	}


	public void setRoll(Integer roll) {
		this.roll = roll;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Integer getMarks() {
		return marks;
	}


	public void setMarks(Integer marks) {
		this.marks = marks;
	}


	@Override
	public String toString() {
		return "Student [roll=" + roll + ", name=" + name + ", address=" + address + ", marks=" + marks + "]";
	}
	

	
	
}

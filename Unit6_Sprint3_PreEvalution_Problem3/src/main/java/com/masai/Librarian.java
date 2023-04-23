package com.masai;

import java.util.Objects;

public class Librarian {

	private int id;
	private String name;
	private int age;
	private int noOfBooksIssued;
	private String email;
	private String mobile;
    
    
	public Librarian(int id, String name, int age, int noOfBooksIssued, String email, String mobile) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.noOfBooksIssued = noOfBooksIssued;
		this.email = email;
		this.mobile = mobile;
	}
	
	
	public Librarian() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getNoOfBooksIssued() {
		return noOfBooksIssued;
	}
	public void setNoOfBooksIssued(int noOfBooksIssued) {
		this.noOfBooksIssued = noOfBooksIssued;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "Librarian [id=" + id + ", name=" + name + ", age=" + age + ", noOfBooksIssued=" + noOfBooksIssued
				+ ", email=" + email + ", mobile=" + mobile + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(age, email, id, mobile, name, noOfBooksIssued);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Librarian other = (Librarian) obj;
		return age == other.age && Objects.equals(email, other.email) && id == other.id
				&& Objects.equals(mobile, other.mobile) && Objects.equals(name, other.name)
				&& noOfBooksIssued == other.noOfBooksIssued;
	}
    
    

}

package com.masai;

import java.util.Objects;

public class Member {
	private int id;
	private  String name;
	private int age;
	private int noOfBooksBorrowed;
	private String email;
	private String mobile;
	
	
	
	public Member(int id, String name, int age, int noOfBooksBorrowed, String email, String mobile) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.noOfBooksBorrowed = noOfBooksBorrowed;
		this.email = email;
		this.mobile = mobile;
	}
	
	
	public Member() {
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
	public int getNoOfBooksBorrowed() {
		return noOfBooksBorrowed;
	}
	public void setNoOfBooksBorrowed(int noOfBooksBorrowed) {
		this.noOfBooksBorrowed = noOfBooksBorrowed;
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
		return "Member [id=" + id + ", name=" + name + ", age=" + age + ", noOfBooksBorrowed=" + noOfBooksBorrowed
				+ ", email=" + email + ", mobile=" + mobile + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(age, email, id, mobile, name, noOfBooksBorrowed);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return age == other.age && Objects.equals(email, other.email) && id == other.id
				&& Objects.equals(mobile, other.mobile) && Objects.equals(name, other.name)
				&& noOfBooksBorrowed == other.noOfBooksBorrowed;
	}
    
    
    
}

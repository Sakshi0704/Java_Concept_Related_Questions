package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;

//jobseeker{
//	id: int Primary key 
//	email: varchar
//	address: varchar
//	mobNo: varchar
//	category: varchar (Marketing, IT, HR, Account)
//	experience: int (Year)
//}

@Entity
public class Jobseeker {
		
	@Id
	private int id;
	
	private String email;
	
	private String address;
	
	private String modNo;
	
	private String category; //(Marketing,IT,HR,Account)
	
	private int experience;

	public Jobseeker() {
	
	}

	public Jobseeker(int id, String email, String address, String modNo, String category, int experience) {
		super();
		this.id = id;
		this.email = email;
		this.address = address;
		this.modNo = modNo;
		this.category = category;
		this.experience = experience;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getModNo() {
		return modNo;
	}

	public void setModNo(String modNo) {
		this.modNo = modNo;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	@Override
	public String toString() {
		return "Jobseeker [id=" + id + ", email=" + email + ", address=" + address + ", modNo=" + modNo + ", category="
				+ category + ", experience=" + experience + "]";
	}
	
	
	
}

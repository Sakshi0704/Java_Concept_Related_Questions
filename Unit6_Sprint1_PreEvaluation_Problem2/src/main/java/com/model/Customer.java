package com.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



//customer{
//	id: int Primary key [Auto Generated]
//	name: varchar
//	email: varchar
//	address: varchar
//	data_Gb: int
//	price: int
//	recharge_date: yyyy-mm-dd
//}


@Entity
@Table(name = "customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String name;
	private String email;
	private String address;
	private int data_Gb;
	private int price;
	private LocalDate recharge_date;
	
	
	
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



	public int getData_Gb() {
		return data_Gb;
	}



	public void setData_Gb(int data_Gb) {
		this.data_Gb = data_Gb;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public LocalDate getRecharge_date() {
		return recharge_date;
	}



	public void setRecharge_date(LocalDate recharge_date) {
		this.recharge_date = recharge_date;
	}



	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", data_Gb="
				+ data_Gb + ", price=" + price + ", recharge_date=" + recharge_date + "]";
	}

	
	
}

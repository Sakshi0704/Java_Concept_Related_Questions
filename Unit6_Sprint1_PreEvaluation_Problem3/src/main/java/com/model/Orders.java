package com.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//bookingId: 101,
//orderNumber: "Zo5678768",
//pizza: "Veg_Cheeze_Pizza",
//prize: 500,  [In Rs]
//deliveryAddress: "Ranjana Palace 1st Block, Andheri, Mumbai",
//created_timestamp : 2019-12-11 10:58:37. [use current time stamp]

@Entity

public class Orders {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	
	private String orderNumber;
	
	private String pizza;
	
	private int prize;
	
	private String deliveryAddress;
	
	private LocalDateTime created_timestamp;

	
	
	@Override
	public String toString() {
		return "Orders [bookingId=" + bookingId + ", orderNumber=" + orderNumber + ", pizza=" + pizza + ", prize="
				+ prize + ", deliveryAddress=" + deliveryAddress + ", created_timestamp=" + created_timestamp + "]";
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getPizza() {
		return pizza;
	}

	public void setPizza(String pizza) {
		this.pizza = pizza;
	}

	public int getPrize() {
		return prize;
	}

	public void setPrize(int prize) {
		this.prize = prize;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public LocalDateTime getCreated_timestamp() {
		return created_timestamp;
	}

	public void setCreated_timestamp(LocalDateTime created_timestamp) {
		this.created_timestamp = created_timestamp;
	}
	
	
	 
	
}

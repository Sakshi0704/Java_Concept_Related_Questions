package com.entities;


import java.sql.Timestamp;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int itemId;
	 private String name;
	 private LocalDate estimatedDeliveryDate;
	 private Timestamp createdAt;
	 
	 
	 @ManyToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "order_id")
	 private Order order;
	 
	 
	 
	
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", name=" + name + ", estimatedDeliveryDate=" + estimatedDeliveryDate
				+ ", createdAt=" + createdAt + "]";
	}


	public Timestamp getCreatedAt() {
		return createdAt;
	}


	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getEstimatedDeliveryDate() {
		return estimatedDeliveryDate;
	}

	public void setEstimatedDeliveryDate(LocalDate estimatedDeliveryDate) {
		this.estimatedDeliveryDate = estimatedDeliveryDate;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}



	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	 
	
}

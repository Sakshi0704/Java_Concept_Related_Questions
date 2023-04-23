package com.dao;

import java.util.List;

import com.model.Orders;

public interface PizzaOrderDao {
	
	public void orderPizza(Orders order);
	
	//public List<Order> listOfOrderByOrderNumber(String orderNumber);
	public Orders createOrder(String orderNumber);
	
	public List<String> listOfUniqueOrder();
	
	public void deleteOrderByBookingId(int bookingId);
	
}

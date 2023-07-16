package com.masai.Service;

import java.time.LocalDate;
import java.util.List;

import com.masai.Exception.CartException;
import com.masai.Exception.OrderException;
import com.masai.model.Orders;

public interface OrderService {
	
	public Orders addOrder(Integer customerId) throws OrderException,CartException;
	public Orders updateOrder(Orders order) throws OrderException;
	public String removeOrder(Integer orderId) throws OrderException;
	public Orders viewOrderById(Integer orderId) throws OrderException;
	public List<Orders> AllOrder() throws OrderException;
	
	
}

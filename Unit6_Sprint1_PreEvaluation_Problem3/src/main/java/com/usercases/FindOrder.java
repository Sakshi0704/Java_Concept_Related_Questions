package com.usercases;

import com.dao.PizzaOrderDao;
import com.dao.PizzaOrderDaoImpl;
import com.model.Orders;

public class FindOrder {
	
	public static void main(String args[]) {
		PizzaOrderDao pod = new PizzaOrderDaoImpl();
		try {
			Orders order = pod.createOrder("7513axz");
			System.out.println(order);
		}catch(Exception ex) {
			System.out.println(ex);
		}
	}
	
	
}

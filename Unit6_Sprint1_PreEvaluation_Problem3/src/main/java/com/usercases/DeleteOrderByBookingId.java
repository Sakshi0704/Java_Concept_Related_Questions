package com.usercases;

import java.util.List;

import com.dao.PizzaOrderDao;
import com.dao.PizzaOrderDaoImpl;

public class DeleteOrderByBookingId {
	
	public static void main(String args[]) {
		PizzaOrderDao pod = new PizzaOrderDaoImpl();
		try {
			pod.deleteOrderByBookingId(1);
			System.out.println("Delete Successfully");
		}catch(Exception ex) {
			System.out.println(ex);
		}
	}
	
	
}

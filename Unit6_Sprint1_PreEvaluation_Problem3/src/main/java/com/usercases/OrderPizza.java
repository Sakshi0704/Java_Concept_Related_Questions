package com.usercases;

import com.dao.PizzaOrderDao;
import com.dao.PizzaOrderDaoImpl;
import com.model.Orders;

public class OrderPizza {
		
	public static void main(String args[]) {
		PizzaOrderDao orderDao = new PizzaOrderDaoImpl();
		
		Orders orders = new Orders();
		
		
		orders.setOrderNumber("1253axz");
		orders.setDeliveryAddress("Delhi suryaAppar flat no - 120");
		orders.setPizza("veg_cheeze");
		orders.setPrize(500);
		
		try {
			orderDao.orderPizza(orders);
			System.out.println("Order successfully ");
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
		Orders order1 = new Orders();
		
		
		order1.setOrderNumber("1413axz");
		order1.setDeliveryAddress("Delhi suryaAppar flat no - 120");
		order1.setPizza("veg_cheeze");
		order1.setPrize(500);
		
		try {
			orderDao.orderPizza(order1);
			System.out.println("Order successfully ");
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
		Orders order2 = new Orders();
		order2.setOrderNumber("7513axz");
		order2.setDeliveryAddress("Delhi suryaAppar flat no - 120");
		order2.setPizza("panner_cheeze");
		order2.setPrize(500);
		
		try {
			orderDao.orderPizza(order2);
			System.out.println("Order successfully ");
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
	}
	
}

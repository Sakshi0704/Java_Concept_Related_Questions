package com.usecases;

import java.sql.Timestamp;
import javax.persistence.EntityManager;
import com.dao.OrderItemDao;
import com.dao.OrderItemDaoImpl;
import com.entities.Order;
import com.exceptions.OrderNotFoundException;
import com.utility.EMUtil;

public class AddOrder {
		public static void main(String args[]) {
			
			EntityManager em = EMUtil.getConnection();
			
			Order order = new Order();
			order.setCreatedAt(new Timestamp(System.currentTimeMillis())); // in to search ......
			order.setDeliveryAddress("flat no 105, surya appart in Delhi");
			order.setTotalAmount(120);
			
			OrderItemDao odao = new OrderItemDaoImpl();
			System.out.println("Add Succussfully");
			try {
				odao.addOrder(order);
			} catch (OrderNotFoundException e) {
				System.out.println(e.getMessage());
			}
	
		}

}

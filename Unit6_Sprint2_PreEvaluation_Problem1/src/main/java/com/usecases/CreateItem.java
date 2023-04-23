package com.usecases;

import java.sql.Timestamp;
import java.time.LocalDate;
import javax.persistence.EntityManager;
import com.dao.OrderItemDao;
import com.dao.OrderItemDaoImpl;
import com.entities.Item;

import com.utility.EMUtil;

public class CreateItem {
	public static void main(String args[]) {
		
		EntityManager em = EMUtil.getConnection();
		
		Item item = new Item();
		item.setName("Panner Pizza");
		item.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		
		item.setEstimatedDeliveryDate(LocalDate.now());
	
		OrderItemDao odao = new OrderItemDaoImpl();
	
		
		System.out.println("Add Succussfully");
		try {
			odao.createItem(item, 1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}

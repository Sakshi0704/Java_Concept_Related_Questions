package com.usecases;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import com.dao.OrderItemDao;
import com.dao.OrderItemDaoImpl;
import com.entities.Item;
import com.utility.EMUtil;

public class CreateItemsList {
	public static void main(String args[]) {
		
		EntityManager em = EMUtil.getConnection();
		
		
		List<Item> list = new ArrayList<>();
		Item item1 = new Item();
		item1.setName("Panner Pizza");
		item1.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		
		item1.setEstimatedDeliveryDate(LocalDate.now());
		list.add(item1);
		
		
		Item item2 = new Item();
		item2.setName("Burkar Pizza");
		item2.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		
		item2.setEstimatedDeliveryDate(LocalDate.now().minusDays(5));
		list.add(item2);
		
	
		Item item3 = new Item();
		item3.setName("chize Pizza");
		item3.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		
		item3.setEstimatedDeliveryDate(LocalDate.now().minusDays(7));
		list.add(item3);
		
		Item item4 = new Item();
		item4.setName("Salid Pizza");
		item4.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		
		item4.setEstimatedDeliveryDate(LocalDate.now().plusDays(3));
		list.add(item4);
		
		Item item5 = new Item();
		item5.setName("Panner Pizza");
		item5.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		
		item5.setEstimatedDeliveryDate(LocalDate.now().plusDays(6));
		list.add(item5);
		
		
		
		OrderItemDao odao = new OrderItemDaoImpl();
	
		System.out.println("Add Succussfully");
		try {
			odao.createItems(list, 1);;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}

package com.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.entities.Item;
import com.entities.Order;
import com.exceptions.ItemNotFoundException;
import com.exceptions.OrderNotFoundException;
import com.utility.EMUtil;

public class OrderItemDaoImpl implements OrderItemDao {

	@Override
	public void addOrder(Order order) throws OrderNotFoundException {
		
		EntityManager em = null;
		try {
			if(order == null) {
				throw new OrderNotFoundException("Order is not found");
			}
			em = EMUtil.getConnection();
			
			Order perOrder = em.find(Order.class, order.getOrderId());
			if(perOrder != null) {
				throw new OrderNotFoundException("This Order already exits");
			}
			
			em.getTransaction().begin();
			
			 em.persist(order);
			
			em.getTransaction().commit();
		
		}catch(Exception ex){
			throw new OrderNotFoundException(ex.getMessage());
		}finally {
			em.close();
		}
		
		
	}

	@Override
	public void createItem(Item item, int orderId) throws ItemNotFoundException {
		
		EntityManager em = null;
		try {
			if(item == null) {
				throw new ItemNotFoundException("Item is not found");
			}
			em = EMUtil.getConnection();
			
			Order Order = em.find(Order.class, orderId);
			if(Order == null) {
				throw new OrderNotFoundException("OrderId "+ orderId +"is not found");
			}
			
			item.setOrder(Order);
			Order.getItemList().add(item);
			
			em.getTransaction().begin();
			
			 em.persist(item);
			
			em.getTransaction().commit();
		
		}catch(Exception ex){
			throw new ItemNotFoundException(ex.getMessage());
		}finally {
			em.close();
		}
		
	}

	@Override
	public void createItems(List<Item> items, int orderId) throws ItemNotFoundException {
		
		EntityManager em = null;
		try {
			if(items == null) {
				throw new ItemNotFoundException("list is empty");
			}
			em = EMUtil.getConnection();
			
			Order Order = em.find(Order.class, orderId);
			if(Order == null) {
				throw new OrderNotFoundException("OrderId "+ orderId +"is not found");
			}
			
			items.forEach(item -> item.setOrder(Order));
			Order.getItemList().addAll(items);
			
			em.getTransaction().begin();
			
			 em.persist(Order);
			
			em.getTransaction().commit();
		
		}catch(Exception ex){
			throw new ItemNotFoundException(ex.getMessage());
		}finally {
			em.close();
		}
		
	}

	@Override
	public void getItem(int itemId) throws ItemNotFoundException {
		
		
		EntityManager em = null;
		try {
			
			em = EMUtil.getConnection();
			
			Item item = em.find(Item.class, itemId);
			if(item == null) {
				throw new ItemNotFoundException("ItemId "+ itemId +"is not found");
			}
	
			System.out.println(item +" "+item.getOrder());
		
		}catch(Exception ex){
			throw new ItemNotFoundException(ex.getMessage());
		}finally {
			em.close();
		}
		
	}

	@Override
	public void getOrder(int orderId) throws OrderNotFoundException {
		
		EntityManager em = null;
		try {
			
			em = EMUtil.getConnection();
			
			Order order = em.find(Order.class, orderId);
			if(order == null) {
				throw new OrderNotFoundException("OrderId "+ orderId +"is not found");
			}
	
			
			System.out.println(order +"\n"+ order.getItemList());
		
		}catch(Exception ex){
			throw new OrderNotFoundException(ex.getMessage());
		}finally {
			em.close();
		}
		
	}

	@Override
	public void getItems(LocalDate inputDate) throws ItemNotFoundException {
		
		EntityManager em = null;
		try {
			
			em = EMUtil.getConnection();
			
			String jpql = "from Item where estimatedDeliveryDate > :inputDate";
			
			Query q = em.createQuery(jpql);
			
			q.setParameter("inputDate", inputDate);
			
			List<Item> listItem = q.getResultList();
			
			
			if(listItem.isEmpty()) {
				throw new ItemNotFoundException("No Item Found");
			}
	
			listItem.forEach(item -> System.out.println(item + " " +item.getOrder()));
		
		}catch(Exception ex){
			throw new ItemNotFoundException(ex.getMessage());
		}finally {
			em.close();
		}
		
	}

}

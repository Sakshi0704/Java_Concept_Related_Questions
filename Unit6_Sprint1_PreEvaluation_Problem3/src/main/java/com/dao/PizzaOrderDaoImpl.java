package com.dao;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.model.Orders;
import com.util.EMUtil;

public class PizzaOrderDaoImpl implements PizzaOrderDao {

	@Override
	public void orderPizza(Orders orders) {
		
		EntityManager em = null;
	
		try{
			
		if(orders == null) {
			throw new RuntimeException("Input is null");
		}
		
		em = EMUtil.getConnection();
		
		Orders order1 = em.find(Orders.class, orders.getBookingId());
		if(order1!=null) {
			throw new RuntimeException("This order is already given");
		}
		
		em.getTransaction().begin();
		orders.setCreated_timestamp(LocalDateTime.now());
		em.persist(orders);
		em.getTransaction().commit();
			
		}catch(Exception ex) {
			throw new RuntimeException(ex.getMessage());
		}finally {
			if(em != null) {
				em.close();
			}
		}
		
	}

//	@Override
//	public List<Order> listOfOrderByOrderNumber(String orderNumber) {
//
//		try{
//			
//		}catch(Exception ex) {
//			
//		}finally {
//			
//		}
//		return null;
//	}

	@Override
	public Orders createOrder(String orderNumber) {
		EntityManager em = null;
		
		Orders orders = null;
		
		try{
			
			if(orderNumber == null) {
				throw new RuntimeException("Input is null");
			}
			
			em = EMUtil.getConnection();
			
			String jpql = " select o.bookingId,o.created_timestamp, o.deliveryAddress,o.orderNumber,o.pizza,o.prize from Orders o where o.orderNumber = ?";
			
			 Query query = em.createQuery(jpql);
			
			query.setParameter(1,orderNumber);
			
			orders = (Orders)query.getSingleResult();
			
				
			}catch(Exception ex) {
				throw new RuntimeException(ex.getMessage());
			}finally {
				if(em != null) {
					em.close();
				}
			}
			
		
		return orders;
	}
	
	@Override
	public List<String> listOfUniqueOrder() {
		EntityManager em = null;
	
		List<String> list = null;
		
		try{
			
			em = EMUtil.getConnection();
			
			String jpql = "select o.pizza from Orders o ";
			
			 Query query = em.createQuery(jpql);
			
			list = query.getResultList();
			
			if(list.isEmpty()) {
				throw new RuntimeException("No Record found");
			}
			
			list = new ArrayList<>(new HashSet<>(list));
				
			}catch(Exception ex) {
				throw new RuntimeException(ex.getMessage());
			}finally {
				if(em != null) {
					em.close();
				}
			}
			
		
		return list;
	}

	@Override
	public void deleteOrderByBookingId(int bookingId) {

		EntityManager em = null;
		try{
			em = EMUtil.getConnection();
			
			Orders orders = em.find(Orders.class,bookingId);
			if(orders==null) {
				throw new RuntimeException("This order is not exit in record");
			}
			em.getTransaction().begin();
			em.remove(orders);
			em.getTransaction().commit();
			
		}catch(Exception ex) {
			throw new RuntimeException(ex.getMessage());
		}finally {
			if(em != null) {
				em.close();
			}
		}
		
	}

	

}

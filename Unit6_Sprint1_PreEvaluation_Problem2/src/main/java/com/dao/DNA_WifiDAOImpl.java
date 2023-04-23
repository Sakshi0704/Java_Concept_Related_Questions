package com.dao;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import com.model.Customer;
import com.util.EMUtil;

public class DNA_WifiDAOImpl implements DNA_WifiDAO {

	@Override
	public Customer findCustomerById(int id) {
		
		Customer customer = null;
		EntityManager em = null;
		
		try {
			
			em = EMUtil.getConnection();
			
			customer = em.find(Customer.class, id);
			if(customer==null) {
				throw new RuntimeException("No Such Customer Exits");
			}
			
		}catch(Exception ex){
			throw new RuntimeException(ex.getMessage());
		}
	
		return customer;
	}

	@Override
	public String saveCustomer(Customer Customer) {
		
		EntityManager em = null;
		String result = "Unable to save";
		
		try {
			
			em = EMUtil.getConnection();
			
			if(Customer==null) {
				throw new RuntimeException("Provided object is null");
			}
			
			Customer customer1 = em.find(Customer.class, Customer.getId());
			if(customer1!=null) {
				throw new RuntimeException("Id is already used");
			}
			
			em.getTransaction().begin();
			
			em.persist(Customer);
			
			em.getTransaction().commit();
			
			result = "Add Successfully "+Customer;
			
		}catch(Exception ex){
			throw new RuntimeException(ex.getMessage());
		}
		finally {
			if(em!=null) {
				em.close();
			}
		}
	
		return result;
	}

	@Override
	public String deleteCustomerById(int id) {
		
		EntityManager em = null;
		String result = "Unable to remove";
		
		try {
			
			em = EMUtil.getConnection();
			
			Customer customer1 = em.find(Customer.class,id);
			if(customer1==null) {
				throw new RuntimeException("This Customer record does not exit");
			}
			em.getTransaction().begin();
			
			em.remove(customer1);
			
			em.getTransaction().commit();
			
			result = "Remove Successfully of" + customer1;
			
			
			
		}catch(Exception ex){
			throw new RuntimeException(ex.getMessage());
		}finally {
			if(em!=null) {
				em.close();
			}
		}
	
		return result;
	}

	@Override
	public String updatePrice(int new_price, int id) {
		EntityManager em = null;
		String result = "Unable to remove";
		
		try {
			
			em = EMUtil.getConnection();
			
			Customer customer1 = em.find(Customer.class,id);
			if(customer1==null) {
				throw new RuntimeException("This Customer record does not exit");
			}
			
			em.getTransaction().begin();
			customer1.setPrice(new_price);
			em.merge(customer1);
			em.getTransaction().commit();
			
			result = "Update Price Successfully of" + customer1;
			
			
			
		}catch(Exception ex){
			throw new RuntimeException(ex.getMessage());
		}finally {
			if(em!=null) {
				em.close();
			}
		}
	
		return result;
	}

	@Override
	public String recharge(int data_Gb, int id) {
		EntityManager em = null;
		String result = "Unable to recharge";
		
		try {
			
			em = EMUtil.getConnection();
			
			Customer customer1 = em.find(Customer.class,id);
			if(customer1==null) {
				throw new RuntimeException("This Customer record does not exit");
			}
			
			em.getTransaction().begin();
			customer1.setData_Gb(customer1.getData_Gb()+data_Gb);
			customer1.setRecharge_date(LocalDate.now());
			em.merge(customer1);
			em.getTransaction().commit();
			
			result = "Recharge Successfully of" + customer1;
			
			
			
		}catch(Exception ex){
			throw new RuntimeException(ex.getMessage());
		}finally {
			if(em!=null) {
				em.close();
			}
		}
	
		return result;
	}

	
	
}

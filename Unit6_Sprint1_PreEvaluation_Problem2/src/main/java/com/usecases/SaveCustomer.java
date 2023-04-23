package com.usecases;

import com.dao.DNA_WifiDAO;
import com.dao.DNA_WifiDAOImpl;
import com.model.Customer;



//customer{
//	id: int Primary key [Auto Generated]
//	name: varchar
//	email: varchar
//	address: varchar
//	data_Gb: int
//	price: int
//	recharge_date: yyyy-mm-dd
//}

public class SaveCustomer {
	
	public static void main(String args[]) {
		DNA_WifiDAO wifidao = new DNA_WifiDAOImpl();
		
		Customer c = new Customer();
		
		c.setName("Sakshi");
		
		c.setEmail("sak@gmail.com");
		
		c.setAddress("Delhi");
		
		c.setPrice(120);
		
		try{
			System.out.println(wifidao.saveCustomer(c));
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
		
	}
	
}

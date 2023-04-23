package com.usecases;

import com.dao.DNA_WifiDAO;
import com.dao.DNA_WifiDAOImpl;
import com.model.Customer;

public class DeleteCustomerById {
	public static void main(String args[]) {
		DNA_WifiDAO wifidao = new DNA_WifiDAOImpl();
		
		try{
			System.out.println(wifidao.deleteCustomerById(1));
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
}

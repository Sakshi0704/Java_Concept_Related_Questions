package com.usecases;

import com.dao.DNA_WifiDAO;
import com.dao.DNA_WifiDAOImpl;

public class FindCustomerById {
	public static void main(String args[]) {
		DNA_WifiDAO wifidao = new DNA_WifiDAOImpl();
		
		try{
			System.out.println(wifidao.findCustomerById(1));
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
}

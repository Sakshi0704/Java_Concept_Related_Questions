package com.usecases;

import com.dao.DNA_WifiDAO;
import com.dao.DNA_WifiDAOImpl;

public class Recharge {
	public static void main(String args[]) {
		DNA_WifiDAO wifidao = new DNA_WifiDAOImpl();
		
		try{
			System.out.println(wifidao.recharge(12, 2));
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
}

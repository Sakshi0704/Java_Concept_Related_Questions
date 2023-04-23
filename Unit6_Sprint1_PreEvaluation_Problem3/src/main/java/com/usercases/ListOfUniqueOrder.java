package com.usercases;

import java.util.List;

import com.dao.PizzaOrderDao;
import com.dao.PizzaOrderDaoImpl;

public class ListOfUniqueOrder {
		
	public static void main(String args[]) {
		PizzaOrderDao pod = new PizzaOrderDaoImpl();
		try {
			List<String> list = pod.listOfUniqueOrder();
			list.forEach(System.out::println);
		}catch(Exception ex) {
			System.out.println(ex);
		}
	}

}


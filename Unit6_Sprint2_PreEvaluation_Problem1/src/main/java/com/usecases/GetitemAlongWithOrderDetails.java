package com.usecases;


import javax.persistence.EntityManager;
import com.dao.OrderItemDao;
import com.dao.OrderItemDaoImpl;
import com.utility.EMUtil;

public class GetitemAlongWithOrderDetails {
public static void main(String args[]) {
		
		EntityManager em = EMUtil.getConnection();
		OrderItemDao odao = new OrderItemDaoImpl();
		try {
			odao.getItem(1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}

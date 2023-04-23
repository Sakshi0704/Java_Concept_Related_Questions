package com.usecases;


import javax.persistence.EntityManager;
import com.dao.OrderItemDao;
import com.dao.OrderItemDaoImpl;
import com.utility.EMUtil;

public class GetOrderAlongWithItems {
	public static void main(String args[]) {
		EntityManager em = EMUtil.getConnection();

		OrderItemDao odao = new OrderItemDaoImpl();
		try {
			odao.getOrder(1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}

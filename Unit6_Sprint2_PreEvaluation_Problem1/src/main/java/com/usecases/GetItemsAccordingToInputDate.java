package com.usecases;

import java.time.LocalDate;
import javax.persistence.EntityManager;
import com.dao.OrderItemDao;
import com.dao.OrderItemDaoImpl;
import com.utility.EMUtil;

public class GetItemsAccordingToInputDate {
public static void main(String args[]) {
		
		EntityManager em = EMUtil.getConnection();
		
		OrderItemDao odao = new OrderItemDaoImpl();
		try {
			odao.getItems(LocalDate.parse("2023-04-09"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}

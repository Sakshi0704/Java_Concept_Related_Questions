package com.usecases;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.model.Account;
import com.utility.EMUtil;

public class Demo {
	public static void main(String args[]) {
		
		EntityManager em = EMUtil.getConnection();
		
		  Query q = em.createNamedQuery("account.getBalance");
		
		  q.setParameter("bal", 5000);
		  
		  List<Account> list = q.getResultList();
		
		  for(Account acc : list) {
			  System.out.println(acc);
		  }
		
	}
}

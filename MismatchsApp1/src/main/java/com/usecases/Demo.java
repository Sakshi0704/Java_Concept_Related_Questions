package com.usecases;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.model.Address;
import com.model.Employee;
import com.utility.EMUtil;

public class Demo {
	public static void main(String args[]) {
		
		EntityManager em = EMUtil.getConnection();
		
		String jpql = "from Employee where ename = 'Ramesh'";
		
		Query q = em.createQuery(jpql);
		
		List<Employee> emps = q.getResultList();
		
		for(Employee emp : emps) {
			Set<Address> addrs = emp.getAddress();
			
			for(Address adr : addrs) {
				System.out.println(adr);
			}
		}
		
		System.out.println("Done");
		
	}
}

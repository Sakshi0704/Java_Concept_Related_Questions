package com.entities;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.utility.EMUtil;

public class Demo {
	public static void main(String[] args) {
		  EntityManager em = EMUtil.getConnection();
		 
			 Department d1 = new Department();
				d1.setDname("sales");
				d1.setLocation("kolkata");
		
			 Department d2 = new Department();
				d2.setDname("Marketing");
				d2.setLocation("delhi");
		
			// creating employee without department
			 Employee emp1 = new Employee();
				emp1.setName("ram");
				emp1.setSalary(5000);
			
			Employee emp2 = new Employee();
				emp2.setName("dinesh");
				emp2.setSalary(3000);

			// associating department with both employee(ram,dinesh) with dept sales
				emp1.getDeptList().add(d1);
				emp2.getDeptList().add(d1);
		
			// associating dept(sales) with both emp1 and emp2
				d1.getEmpList().add(emp1);
				d1.getEmpList().add(emp2);

		
			// assume dinesh is working in 2 dept (sales and marketing)
				emp2.getDeptList().add(d2);
				d2.getEmpList().add(emp2);

		
			em.getTransaction().begin();
			
				em.persist(d1);
				em.persist(d2);
			
			em.getTransaction().commit();			

			em.close();
		  System.out.println("Done.....");
	  }
}

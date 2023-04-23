package com.usecases;


import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.entities.Student;
import com.utility.EMUtil;

public class Demo {
		public static void main(String args[]) {
			EntityManager em= null;
			try {
				Scanner sr = new Scanner(System.in);
				 em = EMUtil.getConnection();
				String name = "Suresh";
				
				String jpql = "select s from Student s where s.name = :name";
				
				TypedQuery<Student> query = em.createQuery(jpql,Student.class);
				
				query.setParameter("name" , name);
				
				Student student  = query.getSingleResult();
				
				if(student == null) {
					throw new RuntimeException("No such data available");
				}
				
				//System.out.println(student);
				student.displayDetails();
				System.out.println("\nstudentpayFee : " + student.payFee());
				
			}catch(Exception ex) {
				System.out.println(ex.getMessage());
			}finally {
				em.close();
			}
			
		}

}

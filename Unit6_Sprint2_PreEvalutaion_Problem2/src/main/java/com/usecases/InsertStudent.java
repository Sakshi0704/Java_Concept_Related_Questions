package com.usecases;

import javax.persistence.EntityManager;
import com.entities.DayScholar;
import com.entities.Hosteller;
import com.utility.EMUtil;

public class InsertStudent {
	public static void main(String args[]) {
		
		EntityManager em = EMUtil.getConnection();
		
		DayScholar student1 = new DayScholar();
		student1.setName("Ram");
		student1.setAddress("Delhi");
		student1.setExamFee(1200);
		student1.setTransportFee(1000);
		
		DayScholar student2 = new DayScholar();
		student2.setName("Vinay");
		student2.setAddress("Noida");
		student2.setExamFee(1200);
		student2.setTransportFee(1000);
		
		
		Hosteller student3 = new Hosteller();
		student3.setName("Amit");
		student3.setAddress("Gujrat");
		student3.setExamFee(1200);
		student3.setHostelFee(1500);
		
		Hosteller student4 = new Hosteller();
		student4.setName("Suresh");
		student4.setAddress("Hariyana");
		student4.setExamFee(1200);
		student4.setHostelFee(1500);
		
		em.getTransaction().begin();
		
		em.persist(student1);
		em.persist(student2);
		em.persist(student3);
		em.persist(student4);
		
		em.getTransaction().commit();
		
		
		em.close();
	}
}

package com.usecases.jdbc;

import com.dao.ConsultancyDAO;
import com.exceptions.SomethingWentWrong;
import com.model.Jobseeker;
import com.util.GetJob;

public class SaveJobSeeker {
	public static void main(String args[]) {
		try {
			ConsultancyDAO consultancyDAO = GetJob.getInstanceofCounsultancyDAO("JDBC");
			
			Jobseeker jobSeeker = new Jobseeker();
			//int id, String email, String address, String modNo, String category, int experience	
			jobSeeker.setId(2);
			jobSeeker.setEmail("sak@gmail.com");
			jobSeeker.setAddress("Delhi");
			jobSeeker.setModNo("990516245");
			jobSeeker.setCategory("Marketing");//(Marketing,IT,HR,Account)
			jobSeeker.setExperience(5);
	
			
		    System.out.println(consultancyDAO.saveJobseeker(jobSeeker));
			
		} catch (SomethingWentWrong e) {
			System.out.println(e.getMessage());
		}
	}
}

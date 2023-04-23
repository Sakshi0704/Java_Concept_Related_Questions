package com.usecases.orm;

import com.dao.ConsultancyDAO;
import com.exceptions.SomethingWentWrong;
import com.model.Jobseeker;
import com.util.GetJob;

public class FindJobSeeker {
	public static void main(String args[]) {
		try {
			ConsultancyDAO consultancyDAO = GetJob.getInstanceofCounsultancyDAO("ORM");
			
			//Jobseeker jobSeeker = new Jobseeker();
	
		    System.out.println(consultancyDAO.findJobseekerById(1));
			
		} catch (SomethingWentWrong e) {
			System.out.println(e.getMessage());
		}
	}
}

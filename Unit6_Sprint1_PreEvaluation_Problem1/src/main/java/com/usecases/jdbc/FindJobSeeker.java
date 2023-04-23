package com.usecases.jdbc;

import com.dao.ConsultancyDAO;
import com.exceptions.SomethingWentWrong;
import com.util.GetJob;

public class FindJobSeeker {
	public static void main(String args[]) {
		try {
			ConsultancyDAO consultancyDAO = GetJob.getInstanceofCounsultancyDAO("JDBC");
			
			//Jobseeker jobSeeker = new Jobseeker();
	
		    System.out.println(consultancyDAO.findJobseekerById(2));
			
		} catch (SomethingWentWrong e) {
			System.out.println(e.getMessage());
		}
	}
}

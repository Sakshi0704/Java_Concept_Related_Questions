package com.usecases.orm;

import com.dao.ConsultancyDAO;
import com.exceptions.SomethingWentWrong;
import com.util.GetJob;

public class UpdateJobSeekerExperience {
	public static void main(String args[]) {
		try {
			ConsultancyDAO consultancyDAO = GetJob.getInstanceofCounsultancyDAO("ORM");
			
		    System.out.println( consultancyDAO.updateJobseekerExperience(1, 3));
			
		} catch (SomethingWentWrong e) {
			System.out.println(e.getMessage());
		}
	}
}

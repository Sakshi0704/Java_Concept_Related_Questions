package com.usecases.jdbc;

import com.dao.ConsultancyDAO;
import com.exceptions.SomethingWentWrong;
import com.util.GetJob;

public class DeleteJobSeeker {
	public static void main(String args[]) {
		try {
			ConsultancyDAO consultancyDAO = GetJob.getInstanceofCounsultancyDAO("JDBC");
			
		    System.out.println( consultancyDAO.deleteJobseekerById(1));
			
		} catch (SomethingWentWrong e) {
			System.out.println(e.getMessage());
		}
	}
}

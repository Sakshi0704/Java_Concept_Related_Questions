package com.dao;

import com.exceptions.SomethingWentWrong;
import com.model.Jobseeker;

public interface ConsultancyDAO {
	
	Jobseeker findJobseekerById(int id) throws SomethingWentWrong;
	String saveJobseeker(Jobseeker jobseeker) throws SomethingWentWrong;
	String deleteJobseekerById(int id) throws SomethingWentWrong;
	String updateJobseekerExperience(int id, int experience) throws SomethingWentWrong;
}

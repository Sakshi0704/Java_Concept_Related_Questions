package com.dao;

import javax.persistence.EntityManager;

import com.exceptions.SomethingWentWrong;
import com.model.Jobseeker;
import com.util.EMUtil;

public class ConsultancyDaoOrmImpl implements ConsultancyDAO {

	public Jobseeker findJobseekerById(int id) throws SomethingWentWrong {
		
			EntityManager em = EMUtil.getEntityMangaer();
		
		   Jobseeker jb = em.find(Jobseeker.class, id);
		   
		   em.close();
		   
		   if(jb==null) {
			   throw new SomethingWentWrong("no record found is null");
		   }
		  
		return jb;
	
	}

	public String saveJobseeker(Jobseeker jobseeker) throws SomethingWentWrong {
		
		EntityManager em = null;
		String result = "Unable to add";
		try {
			if(jobseeker == null) {
				throw new SomethingWentWrong("provided obj is null");
			}
			em = EMUtil.getEntityMangaer();
			
			Jobseeker jobseeker1 = em.find(Jobseeker.class, jobseeker.getId());
			
			if(jobseeker1 != null) {
				throw new SomethingWentWrong("Job Seeker already added with this id");
			}
			
			em.getTransaction().begin();
			
			em.persist(jobseeker);	
			
			result = "add successfully";
			
			em.getTransaction().commit();
			
		}catch(Exception ex) {
			throw new SomethingWentWrong(ex.getMessage());
		}finally {
			if(em!=null) {
				em.close();
			}
		}
		
		return result;
	}

	public String deleteJobseekerById(int id) throws SomethingWentWrong {
		
		EntityManager em = null;
		String result = "Unable to remove";
		try {
			
			
			em = EMUtil.getEntityMangaer();
			
			Jobseeker jb = em.find(Jobseeker.class, id);
			if(jb==null) {
				throw new SomethingWentWrong("there is no such record avaiable");
			}
			
			em.getTransaction().begin();
			
			em.remove(jb);	
		
			result = "remove successfully";
			
			em.getTransaction().commit();
			
			
		}catch(Exception ex) {
			throw new SomethingWentWrong(ex.getMessage());
		}finally {
			if(em!=null) {
				em.close();
			}
		}
		
	   return result;
	}

	public String updateJobseekerExperience(int id, int experience) throws SomethingWentWrong {
		
		EntityManager em = null;
		String result = "Unable to update";
		try {
			
			
			em = EMUtil.getEntityMangaer();
			
			Jobseeker jb = em.find(Jobseeker.class, id);
			if(jb==null) {
				throw new SomethingWentWrong("there is no such record avaiable to update");
			}
			
			em.getTransaction().begin();
			jb.setExperience(jb.getExperience()+experience);
			em.merge(jb);
		
			result = "update successfully";
			
			em.getTransaction().commit();
			
			
		}catch(Exception ex) {
			throw new SomethingWentWrong(ex.getMessage());
		}finally {
			if(em!=null) {
				em.close();
			}
		}
		
	   return result;
	}
	

}

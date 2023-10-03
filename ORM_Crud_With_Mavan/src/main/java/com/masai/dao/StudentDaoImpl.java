package com.masai.dao;

import javax.persistence.EntityManager;

import com.masai.exception.StudentException;
import com.masai.model.Student;
import com.masai.utility.EMUtils;



public class StudentDaoImpl implements StudentDao{

	@Override
	public Student findStudentById(int id) throws StudentException {
		// TODO Auto-generated method stub
		Student student = null;
		try {
			
		EntityManager em = EMUtils.getEntityManager();
		
		student = em.find(Student.class,id);
		if(student==null) {
			throw new StudentException("Student not found with StudentId "+id);
		}
			
		}catch(RuntimeException ex) {
			throw new StudentException(ex.getMessage());
		}
	  return student;
	}

	@Override
	public String saveStudent(Student student) throws StudentException {
		
		String str = null;
		try {
			if(student==null) {
				throw new StudentException("Null as value given");
			}
			
			EntityManager em = EMUtils.getEntityManager();
			
			em.getTransaction().begin();
			
			em.persist(student);
			
			em.getTransaction().commit();
			
			str = "Saved Student successfully Into Record";
			
		}catch(RuntimeException ex) {
			throw new StudentException(ex.getMessage());
		}
		
		return str;
	}

	@Override
	public String deleteStudentById(int id) throws StudentException {
		// TODO Auto-generated method stub
		
		String str = null;
		try {
			
			EntityManager em = EMUtils.getEntityManager();
			
			Student student = em.find(Student.class, id);
			if(student==null) {
				throw new StudentException("Student does not exist in record");
			}
			em.getTransaction().begin();
			em.remove(student);
			em.getTransaction().commit();
			
			str = "Delete Student successfully into record";
			
		}catch(RuntimeException ex) {
			throw new StudentException(ex.getMessage());
		}
		
		return str;
	}

	@Override
	public String updateStudentLevel(int id, int level) throws StudentException {
		// TODO Auto-generated method stub
		
		String str = null;
		
		try {
			
			EntityManager em = EMUtils.getEntityManager();
			
			Student student = em.find(Student.class, id);
			
			if(student==null) {
				throw new StudentException("Student does not exist in record");
			}
			
			em.getTransaction().begin();
			student.setLevel(student.getLevel()+level);
			em.getTransaction().commit();
			
			str = "Update Student successfully into record";
			
		}catch(RuntimeException ex) {
			throw new StudentException(ex.getMessage());
		}
		
		return str;
	}

}

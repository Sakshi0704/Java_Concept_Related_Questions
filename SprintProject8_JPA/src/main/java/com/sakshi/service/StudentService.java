package com.sakshi.service;

import java.util.List;

import com.sakshi.exception.StudentException;
import com.sakshi.model.Student;

public interface StudentService {

	public Student saveStudent(Student student);
	 
	public Student getStudentByRoll(Integer roll) throws StudentException;
	
	public List<Student> getAllStudentDetails() throws StudentException;
	
	
	
}

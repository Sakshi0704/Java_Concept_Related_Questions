package com.sakshi.service;

import java.util.List;

import com.sakshi.exception.StudentException;
import com.sakshi.model.Student;
import com.sakshi.model.StudentDTO;

public interface StudentService {

	public Student saveStudent(Student student);
	 
	public Student getStudentByRoll(Integer roll) throws StudentException;
	
	public List<Student> getAllStudentDetails() throws StudentException;
	
	public Student getStudentByAddress(String address) throws StudentException;
	
}

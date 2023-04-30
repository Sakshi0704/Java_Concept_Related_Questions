package com.sakshi.service;

import java.util.List;

import com.sakshi.exception.StudentException;
import com.sakshi.model.Student;
import com.sakshi.model.StudentDTO;

public interface StudentService {

	public Student saveStudent(Student student);
	 
	public Student getStudentByRoll(Integer roll) throws StudentException;
	
	public List<Student> getAllStudentDetails() throws StudentException;
	
	public Student deletStudentByRoll(Integer roll)throws StudentException;
	
	public Student updateStudent(Integer roll, StudentDTO student)throws StudentException;
	
	public Student updateStudentMarks(Integer roll, Integer graceMarks) throws StudentException;
	
}

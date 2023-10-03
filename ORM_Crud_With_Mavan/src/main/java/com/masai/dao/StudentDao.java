package com.masai.dao;

import com.masai.exception.StudentException;
import com.masai.model.Student;

public interface StudentDao {

	Student findStudentById(int id) throws StudentException;
	
	String saveStudent(Student student) throws StudentException;
	
	String deleteStudentById(int id) throws StudentException;
	
	String updateStudentLevel(int id, int level) throws StudentException;
	
}

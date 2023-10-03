package com.masai.ui;

import java.util.Scanner;

import com.masai.dao.StudentDao;
import com.masai.dao.StudentDaoImpl;
import com.masai.exception.StudentException;
import com.masai.model.Student;

public class StudentUI {

	private StudentDao stDao;

	public StudentUI() {
		stDao = new StudentDaoImpl();
	}
	
	public void findStudentById(Scanner sr) {
		try {
			System.out.print("Enter student Id : ");
			int id = Integer.parseInt(sr.next());
			
			Student student = stDao.findStudentById(id);
			
			System.out.println(student);	
		}catch(StudentException | RuntimeException ex){
			System.out.println(ex.getMessage());
		}
		
	}
	
	public void saveStudent(Scanner sr) {
		
		try {
		System.out.println("Enter the student details to save in record : ");
		
		System.out.print("Enter the Student email : ");
		String email = sr.next();
		System.out.print("Enter the Student address : ");
		String address = sr.next();
		System.out.print("Enter the Student course : ");
		 String course = sr.next();
		System.out.print("Enter the Student level : ");
		int level = Integer.parseInt(sr.next());
		
		Student student = new Student();
		student.setAddress(address);
		student.setCourse(course);
		student.setEmail(email);
		student.setLevel(level);
		
		System.out.println(stDao.saveStudent(student));
		
		}catch(StudentException | RuntimeException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	
	public void deleteStudentById(Scanner sr) {
		try {
			
			System.out.print("Enter the Student Id or Student code : ");
			int studentId = sr.nextInt();
			
			System.out.println(stDao.deleteStudentById(studentId));
			
			
		}catch(StudentException | RuntimeException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void updateStudentLevel(Scanner sr) {
		try {
			System.out.print("Enter Studentd: ");
			Integer id = Integer.parseInt(sr.next());
			
			System.out.print("Enter How Much level need to be update : " );
			Integer level = Integer.parseInt(sr.next());
			
			System.out.println(stDao.updateStudentLevel(id, level));
			
		}catch(StudentException | RuntimeException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	
}

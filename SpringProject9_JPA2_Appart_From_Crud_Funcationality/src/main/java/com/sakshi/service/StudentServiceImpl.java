package com.sakshi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sakshi.exception.StudentException;
import com.sakshi.model.Student;

import com.sakshi.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	
	@Autowired
	 private StudentRepository studentRepository;
	
	
	@Override
	public Student saveStudent(Student student) {
		
		System.out.println(studentRepository.getClass().getName());
		
		Student saveStudent = studentRepository.save(student);
		
		return saveStudent;
	}


	@Override
	public Student getStudentByRoll(Integer roll) throws StudentException {
		
	   Optional<Student> opt = studentRepository.findById(roll);
	   
	   if(opt.isPresent()) {
		   Student existingStudent = opt.get();
		   return existingStudent;
	   }else {
		   throw new StudentException("Student not found with roll "+roll);
	   }
	   
	   // using functional programming ...
	   
	   //return opt.orElseThrow(() -> new StudentException("Student does not exist with roll "+roll));
	   
	}


	@Override
	public List<Student> getAllStudentDetails() throws StudentException {
		
		
			List<Student> students = studentRepository.findAll();
		
			if(students.isEmpty()) {
				throw new StudentException("No Student Found...");
			}
			else {
				return students;
			}
	
	}


	@Override
	public Student getStudentByAddress(String address) throws StudentException {
		
		 Student student =  studentRepository.findByAddress(address);
		
		 if(student==null) {
			 throw new StudentException("Student does not exist with Address : "+address);
		 }else {
			 return student;
		 }
	}

}

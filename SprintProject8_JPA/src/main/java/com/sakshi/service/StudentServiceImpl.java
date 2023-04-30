package com.sakshi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sakshi.exception.StudentException;
import com.sakshi.model.Student;
import com.sakshi.model.StudentDTO;
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
	public Student deletStudentByRoll(Integer roll) throws StudentException {
		
		   Student existingStudent = studentRepository.findById(roll).orElseThrow(()->new StudentException("Student does not exist"));	
		
		   	studentRepository.delete(existingStudent);
		   	
		   return existingStudent;
	}


	@Override
	public Student updateStudent(Integer roll, StudentDTO student) throws StudentException {
		
		Student existingStudent = studentRepository.findById(roll).orElseThrow(() -> new StudentException("Invalid Student roll number "+roll));
		
		existingStudent.setName(student.getName());
		existingStudent.setMarks(student.getMarks());
		existingStudent.setAddress(student.getAddress());
		
		
		
		// here save() method will work as save or merge with respect to id fields.
		return studentRepository.save(existingStudent);
		
		
	}


	@Override
	public Student updateStudentMarks(Integer roll, Integer graceMarks) throws StudentException {
		
		Student existingStudent = studentRepository.findById(roll).orElseThrow(()-> new StudentException("Student does not exist with roll no "+roll ));
		
		existingStudent.setMarks(existingStudent.getMarks()+graceMarks);
		
		
		return studentRepository.save(existingStudent);
	}

}

package com.sakshi.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sakshi.model.Student;

import jakarta.annotation.PostConstruct;
import java.util.ArrayList;

import java.util.Map;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@RestController
public class StudentController {

	private Map<Integer,Student> map = new HashMap<>();
	
	
	@PostConstruct
	 public void init() {
		 map.put(10,new Student(10,"Ram","Delhi",800));
		 map.put(11, new Student(11,"Sunil","Delhi",820));
		 map.put(12, new Student(12,"Ramesh","Chennai",840));
		 map.put(13, new Student(13,"Manoj","Kolkata",700));
		 map.put(14, new Student(14,"Suresh","Pune",600)); 
		 
	 }
	
	
	@GetMapping("/students")
	public List<Student> getAllStudentsHandler(){
	
		Collection<Student> collection = map.values();
		

//		List<Student> students = new ArrayList<>();
//		
//		for(Student student : collection) {
//			students.add(student);
//		}
		 
		
		List<Student> students = new ArrayList<>(collection);
		
		return students;
		
	}
	
	
	@PostMapping("/students")
	public String addStudentHandler(@RequestBody Student student) {
		map.put(student.getRoll(), student);
		
		return "Student stored Sucessfully "+student;
	}
	
	
	@GetMapping("/students/{roll}")
	public Student getStudentByRollHandler(@PathVariable Integer roll) {
		
		if(map.containsKey(roll)) {
			Student existingStudent = map.get(roll);
			return existingStudent;
		}else {
			throw new IllegalArgumentException("Student does not exist with Roll "+roll);
		}
		
	}
	
	
	@PutMapping("/students/{roll}")
	public String updateStudentHandler(@PathVariable Integer roll, @RequestBody Student student) {
		
		if(map.containsKey(roll)) {
			Student existingStudent = map.get(roll);
			
//			existingStudent.setName(student.getName());
//			existingStudent.setAddress(student.getAddress());
//			existingStudent.setMarks(student.getMarks());
			
//  		map.put(roll, existingStudent);
			
			map.put(roll, student);
			return "Student updated successfully.";
		}
		else {
			throw new IllegalArgumentException("Student does not exist with Roll "+roll);
		}
		
	}
	
	
	
	//http://localhost:8080/students/10?gmarks=50
	
	@PatchMapping("/students/{roll}")
	public String updateStudentMarksHandler(@PathVariable Integer roll,@RequestParam Integer gmarks) {
		
		if(map.containsKey(roll)) {
			Student existingStudents = map.get(roll);
			
			existingStudents.setMarks(existingStudents.getMarks()+gmarks);
			
			map.put(roll, existingStudents);
			
			return "Student marks is graced by " + gmarks;
		}else {
			throw new IllegalArgumentException("Student does not exist with roll : "+roll);
		}
		
	}
	
	@DeleteMapping("/students/{roll}")
	public String deleteStudentByRollHandler(@PathVariable Integer roll) {
		if(map.containsKey(roll)) {
			
			map.remove(roll);
			
			return "Student is remove of roll "+roll;
		}
		else {
			throw new IllegalArgumentException("Student does not exist with roll : "+roll);
		}
		
	}
	
}

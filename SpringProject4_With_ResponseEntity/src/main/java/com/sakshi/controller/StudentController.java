package com.sakshi.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Student>> getAllStudentsHandler(){
	
		Collection<Student> collection = map.values();
		

//		List<Student> students = new ArrayList<>();
//		
//		for(Student student : collection) {
//			students.add(student);
//		}
		 
		
		List<Student> students = new ArrayList<>(collection);
		
		return new ResponseEntity<>(students, HttpStatus.OK);
		
	}
	
	
	@PostMapping("/students")
	public ResponseEntity<String> addStudentHandler(@RequestBody Student student) {
		map.put(student.getRoll(), student);
		
		
		String result = "Student stored Successfully "+student;
		
		return new ResponseEntity<>(result,HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/students/{roll}")
	public ResponseEntity<Student> getStudentByRollHandler(@PathVariable Integer roll) {
		
		if(map.containsKey(roll)) {
			Student existingStudent = map.get(roll);
			
			return new ResponseEntity<Student>(existingStudent, HttpStatus.OK);
			
			
		}else {
			throw new IllegalArgumentException("Student does not exist with Roll "+roll);
		}
		
	}
	
	
	@PutMapping("/students/{roll}")
	public ResponseEntity<Student> updateStudentHandler(@PathVariable Integer roll, @RequestBody Student student) {
		
		if(map.containsKey(roll)) {
			Student existingStudent = map.get(roll);
			
//			existingStudent.setName(student.getName());
//			existingStudent.setAddress(student.getAddress());
//			existingStudent.setMarks(student.getMarks());
			
//  		map.put(roll, existingStudent);
			
			map.put(roll, student);
	
	System.out.println("====== what to add some hearders as well as ==================================");
	
		 HttpHeaders headers = new HttpHeaders();
		 
		 headers.add("jwttoken", "safdfkasjdhfksjafjsdlfs");
		 headers.add("pincode", "4273282");
		 
		 ResponseEntity<Student> re = new ResponseEntity<Student>(existingStudent, headers, HttpStatus.FOUND);	
		 return re;	
	
		}
		else {
			throw new IllegalArgumentException("Student does not exist with Roll "+roll);
		}
		
	}
	
	
	
	//http://localhost:8080/students/10?gmarks=50
	
	@PatchMapping("/students/{roll}")
	public ResponseEntity<String> updateStudentMarksHandler(@PathVariable Integer roll,@RequestParam Integer gmarks) {
		
		if(map.containsKey(roll)) {
			Student existingStudents = map.get(roll);
			
			existingStudents.setMarks(existingStudents.getMarks()+gmarks);
			
			map.put(roll, existingStudents);
			
			String result = "Student marks is graced by " + gmarks;
			
			return new ResponseEntity<String>(result,HttpStatus.ACCEPTED);
			
		}else {
			throw new IllegalArgumentException("Student does not exist with roll : "+roll);
		}
		
	}
	
	@DeleteMapping("/students/{roll}")
	public ResponseEntity<String> deleteStudentByRollHandler(@PathVariable Integer roll) {
		if(map.containsKey(roll)) {
			
			map.remove(roll);
			
			String result =  "Student is remove of roll "+roll;
			
			return new ResponseEntity<String>(result, HttpStatus.OK);
		}
		else {
			throw new IllegalArgumentException("Student does not exist with roll : "+roll);
		}
		
	}
	
}

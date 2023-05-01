package com.sakshi.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.sakshi.exception.StudentException;
import com.sakshi.model.Student;

import com.sakshi.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/students")
	public ResponseEntity<Student> registerStudentHandler(@RequestBody Student student){
	
		Student registeredStudent = studentService.saveStudent(student);
		
		return new ResponseEntity<>(registeredStudent,HttpStatus.CREATED);
	}
	
	@GetMapping("/students/{roll}")
	public ResponseEntity<Student> getStudentByRollHandler(@PathVariable("roll") Integer roll) throws StudentException{
		
		Student student = studentService.getStudentByRoll(roll);
		
		return new ResponseEntity<>(student,HttpStatus.FOUND);
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudentsHandler()throws StudentException{
		
		List<Student> students= studentService.getAllStudentDetails();
		
		return new ResponseEntity<>(students,HttpStatus.FOUND);
	}
	
	
	/* we can't use here @GetMapping("/students/{address}) 
	 * because this url is already used in @GetMapping("/students/{roll})
	 * even pathvariable name is different still same url are these 
	 * because annotation and students and number of pathvariable are same 
	 * so we can not use this url */
	
	/*@GetMapping("/getstudents/{address}") 
	public ResponseEntity<Student> getStudentByAddressHandler(@PathVariable String address)throws StudentException{
		
		Student student = studentService.getStudentByAddress(address);
		
		return new ResponseEntity<>(student,HttpStatus.OK);
	} */
	
   //	============= Or above method can be done by @RequestParam  // http://localhost:8080/getstudent?address=delhi ===========
		@GetMapping("/getstudent")  
			public ResponseEntity<Student> getStudentByAddressHandler(@RequestParam("address") String address)throws StudentException{
			Student student = studentService.getStudentByAddress(address);
		
			return new ResponseEntity<>(student,HttpStatus.OK);
		} 
	
}

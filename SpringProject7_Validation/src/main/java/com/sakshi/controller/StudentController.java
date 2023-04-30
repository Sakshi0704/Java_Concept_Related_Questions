package com.sakshi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sakshi.model.Student;

import jakarta.validation.Valid;

@RestController
public class StudentController {

	@PostMapping("/students")
	public ResponseEntity<String> saveStudentHandler(@Valid @RequestBody Student student){
		
		// ---> SL ----> DAL ---> DB
		
		String result = "Student saved sucessfully..."+student;
		
		return new ResponseEntity<>(result,HttpStatus.CREATED);
		
	}
	
}

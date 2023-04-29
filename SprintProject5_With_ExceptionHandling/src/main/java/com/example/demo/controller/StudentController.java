package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@GetMapping("/hello/{num}")
	public String sayHello(@PathVariable Integer num) {
		
		if(num>100) {
			 throw new ArithmeticException("Number should be less then 100");
		}
		
		return "Welcome to Spring Boot "+num;
	}
	
	 
	
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<String> exceptionHandler(ArithmeticException ae){
		
		return new ResponseEntity<>(ae.getMessage(),HttpStatus.BAD_REQUEST);
		
	}
	
}
 
package com.sakshi.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sakshi.exception.InvalidNumberException;

@RestController
public class StudentController {

	@GetMapping("/hello/{num}")
	public String sayHello(@PathVariable Integer num) {
		
		if(num>100) {
			 throw new InvalidNumberException("Number should be less then 100");
		}
		
		return "Welcome to Spring Boot "+num;
	}
	
}
 
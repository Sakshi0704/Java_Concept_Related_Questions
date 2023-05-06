package com.sakshi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sakshi.exception.LoginException;
import com.sakshi.model.LoginDTO;
import com.sakshi.service.LogInService;

@RestController
public class LogInController {

	@Autowired
	private LogInService customerLogin;
	
	
	@PostMapping("/login")
	public ResponseEntity<String> logInCustomer(@RequestBody LoginDTO dto) throws LoginException{
		
		String result = customerLogin.logIntoAccount(dto);
		
		return new ResponseEntity<>(result,HttpStatus.OK);
		
	}
	
	
	
}

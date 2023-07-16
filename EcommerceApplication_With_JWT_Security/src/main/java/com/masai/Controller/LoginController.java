package com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Repository.CustomerRepo;
import com.masai.model.Customer;
import com.masai.model.Users;
import com.masai.service.UserService;


@RestController
public class LoginController {

	@Autowired
	private UserService usersService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@GetMapping("/signIn")
	public ResponseEntity<String> getLoggedInUserDetailsHandler(Authentication auth){
		
		 Users user= usersService.getUsersDetailsByEmail(auth.getName());
		 
		 return new ResponseEntity<>(user.getName()+" Logged In Successfully", HttpStatus.ACCEPTED);	
	}
}

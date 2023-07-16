package com.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.dto.UserDTO;
import com.login.exception.AdminException;
import com.login.exception.UserException;
import com.login.model.User;
import com.login.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Value("${admin.secretKey}")
	private String secretKey = "@qwerty1524";

	@GetMapping
	public ResponseEntity<String> welcomePage() {
		return new ResponseEntity<>("Welcome to the website !", HttpStatus.OK);
	}

	@PostMapping("/signup")
	public ResponseEntity<User> userSignUp(@RequestBody User user) throws UserException {
		return new ResponseEntity<>(userService.addUser(user, false), HttpStatus.ACCEPTED);
	}

	@PostMapping("/signup/{secretKey}")
	public ResponseEntity<User> adminSignUp(@RequestBody User user, @PathVariable String secretKey)
			throws UserException, AdminException {
		if (secretKey.equals(this.secretKey))
			throw new AdminException("Wrong Passcode.");

		return new ResponseEntity<>(userService.addUser(user, true), HttpStatus.ACCEPTED);
	}

	@GetMapping("/userLogin")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public ResponseEntity<String> userLogin(@RequestBody UserDTO dto) {
		return new ResponseEntity<>("Welcome User !", HttpStatus.ACCEPTED);
	}

	@GetMapping("/adminLogin")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<String> adminLogin(@RequestBody UserDTO dto) {
		return new ResponseEntity<>("Welcome Admin !", HttpStatus.ACCEPTED);
	}

}

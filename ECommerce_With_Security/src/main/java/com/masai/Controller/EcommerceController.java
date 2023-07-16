package com.masai.Controller;


import java.util.List;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.ProductException;
import com.masai.Service.ProductService;
import com.masai.Service.UserService;
import com.masai.dto.UserDto;
import com.masai.entities.Product;
import com.masai.entities.User;
import com.masai.util.JWTUtil;

@RestController
public class EcommerceController {
	@Autowired
	private UserService ls;
	@Autowired
	private ProductService ps;
	
	@Autowired
	private JWTUtil jutil;
	@Autowired
	private AuthenticationManager am;
	
	@GetMapping("/masai")
	public ResponseEntity<String> getMessage(){
		return new ResponseEntity<>("Hello",HttpStatus.OK);
	}
	@PostMapping("/masai/user")
	public ResponseEntity<User> createUser(@RequestBody User user) throws LoginException{
		return new ResponseEntity<User>(ls.createUserUser(user), HttpStatus.ACCEPTED);
	}
	@PostMapping("/masai/admin")
	public ResponseEntity<User> createAdmin(@RequestBody User user) throws LoginException{
		return new ResponseEntity<User>(ls.createUserAdmin(user), HttpStatus.ACCEPTED);
	}
	@PostMapping("/masai/admin/addProduct")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) throws ProductException
	{
		return new ResponseEntity<>(ps.addProduct(product), HttpStatus.ACCEPTED);
	}
	@GetMapping("/masai/user/Product")
	public ResponseEntity<List<Product>> showProduct() throws ProductException
	{
		return new ResponseEntity<>(ps.getAllProduct(), HttpStatus.ACCEPTED);
	}
	@GetMapping("/masai/user/Product/{proId}/{userid}")
	public ResponseEntity<List<Product>> addProductToCart(@PathVariable int proId,@PathVariable int userid) throws ProductException
	{
		return new ResponseEntity<>(ps.getAllProduct(), HttpStatus.ACCEPTED);
	}
	
	
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody UserDto userdto) throws Exception{
		try {
			am.authenticate(
					new UsernamePasswordAuthenticationToken(userdto.getUsername(), userdto.getPassword())
					);
			
			
		}catch(Exception ex) {
			throw new Exception("JWT authentication failed");
		}
		return jutil.generateToken(userdto.getUsername());
				
	}
}

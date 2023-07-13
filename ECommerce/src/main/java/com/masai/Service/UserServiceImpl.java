package com.masai.Service;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.masai.dto.UserDto;
import com.masai.entities.User;
import com.masai.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo ur;
	@Autowired
	private BCryptPasswordEncoder passwordEncryter;
	@Override
	public User createUserUser(User u) throws LoginException {
		// TODO Auto-generated method stub
		if(u==null) {
			throw new LoginException("User Not Found");
		}
		u.setPassword(passwordEncryter.encode(u.getPassword()));
		u.setRole("ROLE_USER");
		
		return ur.save(u);
	}
	@Override
	public User createUserAdmin(User u) throws LoginException {
		// TODO Auto-generated method stub
		if(u==null) {
			throw new LoginException("User Not Found");
		}
		u.setPassword(passwordEncryter.encode(u.getPassword()));
		u.setRole("ROLE_ADMIN");
		
		return ur.save(u);
	}

	
}

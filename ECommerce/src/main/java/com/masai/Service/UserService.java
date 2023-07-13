package com.masai.Service;

import javax.security.auth.login.LoginException;

import com.masai.dto.UserDto;
import com.masai.entities.User;

public interface UserService {

	User createUserAdmin(User u) throws LoginException;

	User createUserUser(User u) throws LoginException;

//	User logIn(UserDto ud) throws LoginException;

}

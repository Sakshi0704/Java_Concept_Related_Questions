package com.sakshi.service;

import com.sakshi.exception.LoginException;
import com.sakshi.model.LoginDTO;

public interface LogInService {

	public String logIntoAccount(LoginDTO dto) throws LoginException;
	public String logOutFromAccount(String key) throws LoginException;
	
}

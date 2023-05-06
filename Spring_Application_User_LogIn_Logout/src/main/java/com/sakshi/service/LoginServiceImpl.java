package com.sakshi.service;


import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sakshi.dao.CurrentSessionDao;
import com.sakshi.dao.CustomerDao;
import com.sakshi.exception.LoginException;
import com.sakshi.model.CurrentUserSession;
import com.sakshi.model.Customer;
import com.sakshi.model.LoginDTO;



@Service
public class LoginServiceImpl implements LogInService {

	@Autowired
	private CustomerDao cDao;
	
	@Autowired
	private CurrentSessionDao sDao;
	
	@Override
	public String logIntoAccount(LoginDTO dto) throws LoginException {
		
			Customer existingCustomer = cDao.findByMoblieNo(dto.getMoblieNo());
			
			if(existingCustomer == null) {
				throw new LoginException(" Please Entat a valid mobile number");
			}
			
			Optional<CurrentUserSession> validCutomerSessionOpt = sDao.findById(existingCustomer.getCustomerId());
		
			if(validCutomerSessionOpt.isPresent()) {
				throw new LoginException("User already Logged In With this number");
			}
			
			if(existingCustomer.getPassword() == dto.getPassword()) {
				String key = UUID.randomUUID()+""; // RandomString.make(6)
				CurrentUserSession currentUserSession = new CurrentUserSession(existingCustomer.getCustomerId(),key,LocalDateTime.now());
				sDao.save(currentUserSession);
				
				return currentUserSession.toString();
			}
			else {
				throw new LoginException("Please Enter a vaild password");
			}
	}

	@Override
	public String logOutFromAccount(String key) throws LoginException {
		
		
		CurrentUserSession validCustomerSession = sDao.findByUuId(key);
		
		if(validCustomerSession == null) {
			throw new LoginException("User Not Logged In With This Number");
		}
		
		return "Logged Out !";
	}

}

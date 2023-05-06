package com.sakshi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sakshi.dao.CurrentSessionDao;
import com.sakshi.dao.CustomerDao;
import com.sakshi.exception.CustomerException;
import com.sakshi.model.CurrentUserSession;
import com.sakshi.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	
	@Autowired
	private CustomerDao cDao;
	
	@Autowired
	private CurrentSessionDao sDao;
	
	
	@Override
	public Customer createCustomer(Customer customer) throws CustomerException {
		
		Customer existingCustomer = cDao.findByMoblieNo(customer.getMoblieNo());
		
		if(existingCustomer != null) {
			throw new CustomerException("Customer Already Registered with Mobile number");
		}
		
		
		return cDao.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer, String key) throws CustomerException {
		
		CurrentUserSession loggedInUser = sDao.findByUuId(key);
		
		if(loggedInUser == null) {
			throw new CustomerException("Please provide a valid key to update a customer");
		}
		
		if(customer.getCustomerId() == loggedInUser.getUserId()) {
			
			// If LoggedInUser Id is same as the id of supplied Customer which we want to update
			
			return cDao.save(customer);
		}
		else {
			throw new CustomerException("Invalid Customer Details, please login first");
		}
	}

	
	
	
	
}

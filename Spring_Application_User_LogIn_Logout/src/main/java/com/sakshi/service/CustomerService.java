package com.sakshi.service;

import com.sakshi.exception.CustomerException;
import com.sakshi.model.Customer;

public interface CustomerService {

	public Customer createCustomer(Customer customer) throws CustomerException;
	
	public Customer updateCustomer(Customer customer, String key)throws CustomerException;
	
}

package com.sakshi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sakshi.model.Customer;


@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {

	public Customer findByMoblieNo(String moblieNo);
	
	
}

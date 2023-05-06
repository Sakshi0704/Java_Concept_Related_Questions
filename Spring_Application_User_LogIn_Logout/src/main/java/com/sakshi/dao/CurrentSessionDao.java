package com.sakshi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sakshi.model.CurrentUserSession;

@Repository
public interface CurrentSessionDao extends JpaRepository<CurrentUserSession, Integer>  {

	public CurrentUserSession findByUuId(String uuid);
	
	
}

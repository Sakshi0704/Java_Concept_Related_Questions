package com.masai.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	public User findByUserName(String userName);
}

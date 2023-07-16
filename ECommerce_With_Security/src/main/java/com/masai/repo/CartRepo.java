package com.masai.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.entities.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer> {

}

package com.masai.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.entities.Orders;

public interface OrderRepo extends JpaRepository<Orders, Integer> {

}

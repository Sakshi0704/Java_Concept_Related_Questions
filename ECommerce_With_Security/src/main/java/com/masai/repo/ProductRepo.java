package com.masai.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.entities.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}

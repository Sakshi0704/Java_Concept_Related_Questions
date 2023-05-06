package com.masai.repository;

import com.masai.model.Customer;
import com.masai.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CutomerRepository extends JpaRepository<Customer , Integer> {


}

package com.masai.repository;

import com.masai.model.Booking;
import com.masai.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking , Integer> {

     List<Booking> findByCustomerAndBookingDateBetween(Customer customer , LocalDate date1 , LocalDate date2) ;
}

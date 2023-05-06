package com.masai.repository;

import com.masai.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel , Integer> {

    List<Hotel> findByCity(String city) ;
}

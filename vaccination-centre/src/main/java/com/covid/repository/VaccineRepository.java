package com.covid.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.covid.entities.Vaccine;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, Integer>{
    public Optional<Vaccine> findByVaccineName(String vaccineName);
}
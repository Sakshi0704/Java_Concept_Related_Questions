package com.covid.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.covid.entities.VaccineRegistration;
import com.covid.repository.VaccineRegistrationRepository;



public class VaccineRegistrationServiceImpl implements VaccineRegistrationService{


    @Autowired
    private VaccineRegistrationRepository vaccineRegistrationRepository;
   
    @Override
    public List<VaccineRegistration> getAllVaccineRegistrations() {
        return vaccineRegistrationRepository.findAll();
    }

    @Override
    public Optional<VaccineRegistration> getVaccineRegistrationById(Integer id) {
        return vaccineRegistrationRepository.findById(id);
    }

    @Override
    public VaccineRegistration saveVaccineRegistration(VaccineRegistration vaccineRegistration) {
        return vaccineRegistrationRepository.save(vaccineRegistration);
    }

    @Override
    public void deleteVaccineRegistrationById(Integer id) {
        vaccineRegistrationRepository.deleteById(id);
    }
    
}
package com.covid.service;

import java.util.List;
import java.util.Optional;

import com.covid.entities.VaccineRegistration;



public interface VaccineRegistrationService {
    

    public List<VaccineRegistration> getAllVaccineRegistrations();

    public Optional<VaccineRegistration> getVaccineRegistrationById(Integer id);

    public VaccineRegistration saveVaccineRegistration(VaccineRegistration vaccineRegistration);

    public void deleteVaccineRegistrationById(Integer id);
}
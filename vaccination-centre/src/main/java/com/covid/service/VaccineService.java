// package com.covid.service;

// import java.util.List;
// import java.util.Optional;

// import com.covid.entities.Vaccine;

// public interface VaccineService {

//     // public List<Vaccine> getAllVaccines();

//     // public Optional<Vaccine> getVaccineById(Integer id);

//     // public Vaccine saveVaccine(Vaccine vaccine);

//     // public void deleteVaccineById(Integer id);





    
// }





package com.covid.service;

import java.util.List;

import com.covid.exception.VaccineException;
import com.covid.entities.Vaccine;

public interface VaccineService {

	
	public List<com.covid.entities.Vaccine> getAllService() throws VaccineException;
	
	
	public com.covid.entities.Vaccine getVaccineByName(String vaccineName) throws VaccineException;
	
	
	public com.covid.entities.Vaccine getVaccineById(Integer vaccineId) throws VaccineException;
	
	
	public Vaccine registerNewVaccine(Vaccine Vaccine)throws VaccineException;
	
	public Vaccine updateVaccine(Vaccine vaccine) throws VaccineException ;
	
	public void deleteVaccine(Integer vaccineId) throws VaccineException;
	 
}

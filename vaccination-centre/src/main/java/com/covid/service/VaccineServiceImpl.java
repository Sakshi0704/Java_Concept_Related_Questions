// package com.covid.service;

// import java.util.List;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;

// import com.covid.entities.Vaccine;
// import com.covid.repository.VaccineRepository;

// public class VaccineServiceImpl implements VaccineService{

//     @Autowired
//     private VaccineRepository vaccineRepository;


//     @Override
//     public List<Vaccine> getAllVaccines() {
//         return vaccineRepository.findAll();
//     }

//     @Override
//     public Optional<Vaccine> getVaccineById(Integer id) {
//         return vaccineRepository.findById(id);
//     }

//     @Override
//     public Vaccine saveVaccine(Vaccine vaccine) {
//         return vaccineRepository.save(vaccine);
//     }

//     @Override
//     public void deleteVaccineById(Integer id) {
//         vaccineRepository.deleteById(id);
//     }
    
// }



package com.covid.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid.entities.Vaccine;

import com.covid.exception.VaccineException;
import com.covid.repository.VaccineRepository;
import java.util.List;
import java.util.Optional;



@Service
public class VaccineServiceImpl implements VaccineService {

	
	@Autowired
	private VaccineRepository vaccineRepository;

	
	
	@Override
	public List<Vaccine> getAllService() throws VaccineException {
		
		List<Vaccine> vaccineList = vaccineRepository.findAll();
		
		if(vaccineList.isEmpty()) {
			throw new VaccineException("No Vaccine avaiable");
		}
		
		return vaccineList;
		
	}
	
	
	@Override
	public Vaccine getVaccineByName(String vaccineName) throws VaccineException{
		
		 Optional<Vaccine> vaccine =  vaccineRepository.findByVaccineName(vaccineName);
		 
		 	if(vaccine.isPresent()) {
		 		 return vaccine.get();
		 	}
		 
		 	throw new VaccineException("No Vaccine avaiable");
		
	}


	@Override
	public Vaccine getVaccineById(Integer vaccineId) throws VaccineException {
		
		Optional<Vaccine> vaccine =  vaccineRepository.findById(vaccineId);
		 
	 	if(vaccine.isPresent()) {
	 		 return vaccine.get();
	 	}
	 
	 	throw new VaccineException("No Vaccine avaiable");
	}


	@Override
	public Vaccine registerNewVaccine(Vaccine vaccine) throws VaccineException {
		
			// Vaccine existingVaccine = vaccineRepository.findByVaccineName(vaccine.getVaccineName())
			// 		.orElseThrow(() -> new VaccineException("Vaccine already exist"));
			
			
			// VaccineCount vaccineCount = vaccine.getVaccineCount();
			
			// vaccineCount.setVaccine(vaccine);
			
			return vaccineRepository.save(vaccine);
			
	}
	
	
	
	@Override
	public Vaccine updateVaccine(Vaccine vaccine) throws VaccineException {
		
		Vaccine existingVaccine = vaccineRepository.findById(vaccine.getVaccineId())
				.orElseThrow(() -> new VaccineException("Vaccine does not exist"));

	   return vaccineRepository.save(vaccine);
		
	}

	
	
	@Override
	public void deleteVaccine(Integer vaccineId) throws VaccineException  {
		
		Vaccine existingVaccine = vaccineRepository.findById(vaccineId)
				.orElseThrow(() -> new VaccineException("Vaccine does not exist"));
		

		//return vaccineRepository.save(vaccine);
        vaccineRepository.deleteById(vaccineId);
	}
	
	
}

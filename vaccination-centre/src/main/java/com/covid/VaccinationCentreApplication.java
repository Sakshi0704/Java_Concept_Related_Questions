package com.covid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// implements CommandLineRunner
@SpringBootApplication
public class VaccinationCentreApplication {

	public static void main(String[] args) {
		SpringApplication.run(VaccinationCentreApplication.class, args);
	}

	
	
	
	//  @Override
	// public void run(String... args) throws Exception {
	// 	VaccinationCentre vc1 = new VaccinationCentre();
	// 	vc1.setState("Delhi");
	// 	vc1.setPincode("110032");
	// 	vc1.setLocality("RohtashNagr");
	// 	vc1.setCity("delhi");

	// 	vaccinationCentreRepository.save(vc1);
	// }

}

package com.masai;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.masai")
public class MyAppConfig {

	@Bean
	public List<String> getCities(){
		
		List<String> cities = new ArrayList<>();
		cities.add("delhi");
		cities.add("Kolata");
		cities.add("Thane");
		
		return cities;
	}
	
	@Bean("cities")
	public List<String> getNames(){
		
		List<String> cities = new ArrayList<>();
		cities.add("Noida");
		cities.add("Kolata");
		cities.add("Thane");
		
		return cities;
	}
	
//	@Bean
//	public int getValue() {
//		return 25;
//	}
	
	
}

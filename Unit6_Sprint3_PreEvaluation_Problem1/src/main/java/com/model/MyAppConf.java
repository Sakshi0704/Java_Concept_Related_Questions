package com.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.model")
public class MyAppConf {

	@Bean
	public ArtistManagement getArtist() {
		return new Singer();
	}
	

	
}

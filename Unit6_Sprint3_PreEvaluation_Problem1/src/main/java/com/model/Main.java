package com.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String args[]) {
		
		ApplicationContext ac = new AnnotationConfigApplicationContext(MyAppConf.class);
		
		EventOrganizer event = ac.getBean(EventOrganizerImpl.class);
		
		event.findArtist("Available for booking now!");
		
		((AnnotationConfigApplicationContext)ac).close();
	}
	
}

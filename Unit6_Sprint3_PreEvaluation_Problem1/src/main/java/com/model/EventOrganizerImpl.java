package com.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Lazy(value = true)
public class EventOrganizerImpl implements EventOrganizer{

	@Autowired
	ArtistManagement artist;
	
	public void findArtist(String message) {
		artist.announceAvailability(message);
	}
	
	@PostConstruct
	public void eventInfo() {
		System.out.println("Event info....");
		System.out.println("Date - 2020-05-04");
		System.out.println("Venue - MasaiVer");
	}
	
	@PreDestroy
	public void lastWish() {
		System.out.println("Thank you for attending the Event");
	}

}

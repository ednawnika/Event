package com.project.Event.services;

import com.project.Event.models.Event;
import com.project.Event.repositories.EventRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import com.project.Event.services.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EventService {
	private EventRepository eventRepository;

	public EventService(EventRepository eventRepository){
		this.eventRepository=eventRepository;
		
	}
	

	public void create(Event event) {
		eventRepository.save(event);
	}


	public List<Event> findAll() {
		return (List<Event>) eventRepository.findAll();
	
	}

	public Event showbyIndex(long index) {
		return (Event) eventRepository.findOne(index);

	}
	
	public void updateEvent(Event event) {
		eventRepository.save(event);
	}

	public void deleteEvent(Long index) {
		System.out.println("BYE" + index);
		eventRepository.delete(index);
	}
}

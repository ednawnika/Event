package com.project.Event.repositories;

import com.project.Event.models.Event;
import java.util.List;
import javax.persistence.*;
import com.project.Event.services.EventService;
import com.project.Event.services.UserService;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 												
public interface EventRepository extends CrudRepository<Event,Long>{
	List<Event> findAll();
}

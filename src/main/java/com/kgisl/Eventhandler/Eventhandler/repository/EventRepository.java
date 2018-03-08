package com.kgisl.Eventhandler.Eventhandler.repository;


import com.kgisl.Eventhandler.Eventhandler.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("eventRepository")
public interface EventRepository extends JpaRepository<Event, Long> {

}
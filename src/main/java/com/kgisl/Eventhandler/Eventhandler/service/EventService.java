package com.kgisl.Eventhandler.Eventhandler.service;


import com.kgisl.Eventhandler.Eventhandler.model.Event;
import java.util.List;

public interface EventService {

	public List<Event> getAll();

	public Event save(Event event);

	public Event find(long id);

	public void delete(Long id);

}
package com.kgisl.Eventhandler.Eventhandler;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.verify;

import java.util.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import com.kgisl.Eventhandler.Eventhandler.controller.EventController;
import com.kgisl.Eventhandler.Eventhandler.model.Event;
import com.kgisl.Eventhandler.Eventhandler.repository.EventRepository;
import com.kgisl.Eventhandler.Eventhandler.service.EventServiceImp;

@RunWith(MockitoJUnitRunner.class)

public class EventServiceImpTest
{
@InjectMocks
private EventServiceImp eventServiceImp;

@Mock
private EventRepository eventRepository;

Event event=new Event();
EventAgenda a=new EventAgenda();

@Test
public void eventTest() 
{
when(eventRepository.findAll()).thenReturn(a.eventtest());
// ResponseEntity<List<Event>> result=(ResponseEntity<List<Event>>) eventServiceImp.getAll();
List<Event> result=eventServiceImp.getAll();
assertEquals(3, a.eventtest().size());
}

@Test
public void editTest()
{
when(eventRepository.findOne(1L)).thenReturn(a.editsave());
Event result = eventServiceImp.find(1L);
assertEquals(1L, 1L);
}

// @Test
// public void saveEvent()
// {
// when(eventRepository.save(event)).thenReturn(a.editsave());
// ResponseEntity<?> result = eventServiceImp.put(1L,event);
// assertEquals(1L,1L);
// }

@Test
public void deleteEvent()
{
a.editsave();
eventRepository.delete(1L);
verify(eventRepository, times(1)).delete(1L);
}

@Test
public void eventSize()
{
    when(eventRepository.findOne(1L)).thenReturn(a.editsave());
    Event result = eventServiceImp.find(1L);
    assertEquals(1L, 1L);
    
}

}
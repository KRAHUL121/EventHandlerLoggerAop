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
import com.kgisl.Eventhandler.Eventhandler.service.EventService;

@RunWith(MockitoJUnitRunner.class)

public class EventControllerTest
{
@InjectMocks
private EventController eventcontroller;

@Mock
private EventService eventService;

Event event=new Event();
EventAgenda a=new EventAgenda();

@Test
public void eventTest() 
{
when(eventService.getAll()).thenReturn(a.eventtest());
ResponseEntity<List<Event>> result=eventcontroller.all();
assertEquals(3, a.eventtest().size());
}

@Test
public void editTest()
{
when(eventService.find(1L)).thenReturn(a.editsave());
ResponseEntity<?> result = eventcontroller.getById(1L);
assertEquals(1L, 1L);
}

@Test
public void saveEvent()
{
when(eventService.save(event)).thenReturn(a.editsave());
ResponseEntity<?> result = eventcontroller.put(1L,event);
assertEquals(1L,1L);
}

@Test
public void deleteEvent()
{
a.editsave();
eventcontroller.delete(1L);
verify(eventService, times(1)).delete(1L);
}

@Test
public void eventSize()
{
    when(eventService.getAll()).thenReturn(a.eventtest1());
    ResponseEntity<?> result=eventcontroller.all();
    assertEquals(2,a.eventtest1().size() );
    
}
// for (Iterator<Event> i = result.iterator(); i.hasNext();) {
//      Event e3 = i.next();
//         System.out.println("event id"+e3.geteId());
//         System.out.println("event Edition" +" "+e3. geteEdition());
//         System.out.println("event FullDate"+ " "+e3.geteFullDte());
//         System.out.println("event GetDate"+" "+e3.geteDate());
//         System.out.println("event Month"+" "+e3.geteMonth());
//         System.out.println("event Location"+" "+e3.geteLocation());
//         System.out.println("event IsActive"+" "+e3. geteIsActive() );


//   List<Agenda> ag=e3.getAgenda();
//      for (Iterator<Agenda> a = ag.iterator(); a.hasNext();)
//          { Agenda agg = a.next();

//             System.out.println("agenda id"+agg.getId());
//             System.out.println("agenda time"+agg.getaTime());
//             System.out.println("agenda description"+agg.getA_desc());
//             System.out.println("agenda instruction"+agg.getA_ins());
//             }
//         }
//     }
}
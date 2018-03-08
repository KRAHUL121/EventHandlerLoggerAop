package com.kgisl.Eventhandler.Eventhandler;

import com.kgisl.Eventhandler.Eventhandler.model.Agenda;
import com.kgisl.Eventhandler.Eventhandler.model.Event;
import java.util.*;

public class EventBuilder {
  private Event event = new Event();
  private List<Agenda> agenda;

  public EventBuilder id(Long id) {
	  event.setId(id);
    return this;
  }
  
  public EventBuilder edition(int edition) {
	  event.setEdition(edition);
    return this;
  }
  //  public EventBuilder fulldate(String fulldate) {
	//   event.setDate(fulldate);
  //   return this;
  // }
   public EventBuilder date(String date) {
	  event.setDate(date);
    return this;
  }
  //  public EventBuilder month(String month) {
	//   event.(month);
  //   return this;
  // }
   public EventBuilder location(String location) {
	  event.setLocation(location);
    return this;
  }
   public EventBuilder active(boolean active) {
	  event.setIsActive(active);
    return this;
  }
   public EventBuilder agenda(List<Agenda> agenda) {
	  event.setAgenda(agenda);
    return this;
  }
  
  
  public Event build() {
    return event;
  }
}
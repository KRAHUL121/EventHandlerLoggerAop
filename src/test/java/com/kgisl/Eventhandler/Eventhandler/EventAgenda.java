package com.kgisl.Eventhandler.Eventhandler;

import com.kgisl.Eventhandler.Eventhandler.model.Agenda;
import com.kgisl.Eventhandler.Eventhandler.model.Event;
import java.util.*;

public class EventAgenda
{
public List<Event> eventtest()
{
ArrayList<Agenda> age=new ArrayList<Agenda> ();
Agenda a1=new AgendaBuilder().id(1L).time("10:00 PM").desc("debug").ins("all the best").build();
Agenda a3=new AgendaBuilder().id(1L).time("10:00 PM").desc("debug").ins("all the best").build();
age.add(a1);
age.add(a3);
List<Event> event=new ArrayList<Event>();
event.add(new EventBuilder().id(1L).edition(2).date("29/8/2017").location("block2").active(true).agenda(age).build());
event.add(new EventBuilder().id(1L).edition(2).date("29/8/2017").location("block2").active(true).agenda(age).build());
event.add(new EventBuilder().id(1L).edition(2).date("29/8/2017").location("block2").active(true).agenda(age).build());
return event;
} 
public Event editsave()
{
ArrayList<Agenda> age=new ArrayList<Agenda> ();
Agenda a1=new AgendaBuilder().id(1L).time("10:00 PM").desc("debug").ins("all the best").build();
//private Agenda a2=new Agenda("11:00 PM","paper","all the best");
Agenda a3=new AgendaBuilder().id(1L).time("10:00 PM").desc("debug").ins("all the best").build();
age.add(a1);
age.add(a3);
Event event1=new EventBuilder().id(1L).edition(2).date("29/8/2017").location("block2").active(true).agenda(age).build();
return event1;
}

public List<Event> eventtest1()
{
    Agenda agg=new AgendaBuilder ().id(1L).time("10:00 AM").desc("debug").ins("all the best").build();
     Agenda agg1=new AgendaBuilder ().id(1L).time("10:00 AM").desc("debug").ins("all the best").build();
ArrayList<Agenda> age1=new ArrayList<Agenda> ();
age1.add(agg);
age1.add(agg1);

Event e1=new EventBuilder().id(1L).edition(2).date("29/8/2017").location("block2").active(true).agenda(age1).build();
Event e2=new EventBuilder().id(1L).edition(2).date("29/8/2017").location("block2").active(true).agenda(age1).build();

List<Event> eventlist=new ArrayList<Event>();
eventlist.add(e1);
eventlist.add(e2);

return eventlist;
}


}

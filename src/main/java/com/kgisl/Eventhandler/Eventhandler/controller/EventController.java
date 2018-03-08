package com.kgisl.Eventhandler.Eventhandler.controller;

import com.kgisl.Eventhandler.Eventhandler.model.Event;
import com.kgisl.Eventhandler.Eventhandler.service.EventService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
@RestController
// @CrossOrigin(origins = "http://localhost:10001", maxAge = 3600)
@RequestMapping("api/events")
public class EventController {

    @Autowired
    private EventService eventService;
    

    @GetMapping("/get")
    public @ResponseBody ResponseEntity<List<Event>> all() {
        return new ResponseEntity<>(eventService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<?> post(@RequestBody Event event, UriComponentsBuilder ucBuilder) {
        eventService.save(event);
        HttpHeaders headers = new HttpHeaders();
        Event eventt= eventService.save(event);
        headers.setLocation(ucBuilder.path("/api/events/get/{id}").buildAndExpand(event.getId()).toUri());
        return new ResponseEntity<>( eventt,headers, HttpStatus.CREATED);

    }

    @GetMapping("/get/{eventId}")
    public @ResponseBody ResponseEntity<?> getById(@PathVariable Long eventId) {

        Event event = eventService.find(eventId);
        return new ResponseEntity<>(event, HttpStatus.OK);

    }

    @PutMapping("/put/{eventId}")
    public ResponseEntity<?> put(@PathVariable Long eventId, @RequestBody Event event) {

       

       /* Event currentevent = eventService.find(eventId);
        currentevent.setId(event.getId());
        currentevent.setEdition(event.getEdition());
        currentevent.setDate(event.getDate());
        currentevent.setLocation(event.getLocation());
        currentevent.setIsActive(event.getIsActive()); 
        currentevent.setAgenda(event.getAgenda());
        Agenda a = new Agenda();
        a.setaId(a.getaId());
        a.setTime(a.getTime());
        a.setDescription(a.getDescription());
        a.setInstructor(a.getInstructor());
        Agenda a1 = new Agenda();
        a1.setaId(a.getaId());
        a1.setTime(a.getTime());
        a1.setDescription(a.getDescription());
        a1.setInstructor(a.getInstructor());*/


        eventService.save(event);
        return new ResponseEntity<>(event, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{eventId}")
    public ResponseEntity<?> delete(@PathVariable Long eventId) {
        //Event currentevent = eventService.find(eventId);
        eventService.delete(eventId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
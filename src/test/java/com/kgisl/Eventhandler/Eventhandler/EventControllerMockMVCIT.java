package com.kgisl.Eventhandler.Eventhandler;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kgisl.Eventhandler.Eventhandler.controller.EventController;
import com.kgisl.Eventhandler.Eventhandler.model.Agenda;
import com.kgisl.Eventhandler.Eventhandler.model.Event;
import com.kgisl.Eventhandler.Eventhandler.service.EventService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(value = EventController.class, secure = false)
public class EventControllerMockMVCIT {

    /*   @Mock
     private EventService eventService;
    @InjectMocks
    private EventController eventController;
    
    */
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EventService eventService;

    @Test
    public void getByID() throws Exception {

        Agenda a2 = new Agenda();
        a2.setaId(2L);
        a2.setTime("sdsds");
        a2.setDescription("asasas");
        a2.setInstructor("asasa");

        List<Agenda> alist = new ArrayList<Agenda>();

        alist.add(a2);
        Event currentevent = new Event();
        currentevent.setId(1L);
        currentevent.setEdition(3);
        currentevent.setDate("27/9/17");
        currentevent.setLocation("cbe");
        currentevent.setIsActive(true);
        currentevent.setAgenda(alist);

        given(eventService.find(1L)).willReturn(currentevent);
        mockMvc.perform(get("/api/events/get/1").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                //{  'accountId': 1,  'name': 'NAME1',  'city': 'CBE',  'balance': 100000 }
                .andExpect(content().json(
                        "{'edition': 3,'date': '27/9/17','location': 'cbe','isActive': true,'agenda': [{'time': 'sdsds', 'description': 'asasas','instructor': 'asasa','aId': 2} ],'id': 1}"));
    }

    @Test
    public void getAll() throws Exception {

        Agenda a2 = new Agenda();
        a2.setaId(2L);
        a2.setTime("sdsds");
        a2.setDescription("asasas");
        a2.setInstructor("asasa");

        List<Agenda> alist = new ArrayList<Agenda>();
        alist.add(a2);
        Event currentevent = new Event();
        currentevent.setId(1L);
        currentevent.setEdition(3);
        currentevent.setDate("27/9/17");
        currentevent.setLocation("cbe");
        currentevent.setIsActive(true);
        currentevent.setAgenda(alist);
        List<Event> alist1 = new ArrayList<Event>();
        alist1.add(currentevent);
        given(eventService.getAll()).willReturn(alist1);
        mockMvc.perform(get("/api/events/get/").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(content().json(
                        "[{'edition': 3,'date': '27/9/17','location': 'cbe','isActive': true,'agenda': [{'time': 'sdsds', 'description': 'asasas','instructor': 'asasa','aId': 2} ],'id': 1}]"));

    }

    @Test
    public void postmapping() throws Exception {

        Agenda a2 = new Agenda();
        a2.setaId(2L);
        a2.setTime("sdsds");
        a2.setDescription("asasas");
        a2.setInstructor("asasa");

        List<Agenda> alist = new ArrayList<Agenda>();
        alist.add(a2);
        Event currentevent = new Event();
        currentevent.setId(1L);
        currentevent.setEdition(3);
        currentevent.setDate("27/9/17");
        currentevent.setLocation("cbe");
        currentevent.setIsActive(true);
        currentevent.setAgenda(alist);

        when(eventService.find(currentevent.getId())).thenReturn(currentevent);
        mockMvc.perform(
                post("/api/events/post").contentType(MediaType.APPLICATION_JSON).content(asJsonString(currentevent)))
                .andExpect(status().isCreated());

        //verify(accountService, times(1)).find(acc.getAccountId());
        // verify(accountService, times(1)).save(acc);
        // verifyNoMoreInteractions(accountService);

    }

    @Test
    public void updateByID() throws Exception {

        Agenda a2 = new Agenda();
        a2.setaId(2L);
        a2.setTime("sdsds");
        a2.setDescription("asasas");
        a2.setInstructor("asasa");

        List<Agenda> alist = new ArrayList<Agenda>();
        alist.add(a2);
        Event currentevent = new Event();
        currentevent.setId(1L);
        currentevent.setEdition(3);
        currentevent.setDate("27/9/17");
        currentevent.setLocation("cbe");
        currentevent.setIsActive(true);
        currentevent.setAgenda(alist);
        when(eventService.find(currentevent.getId())).thenReturn(currentevent);

        mockMvc.perform(put("/api/events/put/1", currentevent.getId()).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(currentevent))).andExpect(status().isOk());

        //verify(eventService, times(1)).find(currentevent.getId());
        //verify(eventService, times(1)).save(currentevent);
        // verifyNoMoreInteractions(eventService);
    }

    @Test
    public void deleteByID() throws Exception {

        Agenda a2 = new Agenda();
        a2.setaId(2L);
        a2.setTime("sdsds");
        a2.setDescription("asasas");
        a2.setInstructor("asasa");

        List<Agenda> alist = new ArrayList<Agenda>();
        alist.add(a2);
        Event currentevent = new Event();
        currentevent.setId(1L);
        currentevent.setEdition(3);
        currentevent.setDate("27/9/17");
        currentevent.setLocation("cbe");
        currentevent.setIsActive(true);
        currentevent.setAgenda(alist);
        when(eventService.find(currentevent.getId())).thenReturn(currentevent);

        mockMvc.perform(delete("/api/events/delete/1", currentevent.getId())).andExpect(status().isOk());

        // verify(eventService, times(1)).find(currentevent.getId());
        verify(eventService, times(1)).delete(currentevent.getId());
        verifyNoMoreInteractions(eventService);
    }

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
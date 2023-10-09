package com.geekster.UniversityEventManagement.controller;

import com.geekster.UniversityEventManagement.model.Event;
import com.geekster.UniversityEventManagement.model.Student;
import com.geekster.UniversityEventManagement.service.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Validated
@RestController
public class EventController {
    @Autowired
    EventService eventService;

    //Add event
    @PostMapping("addEvent")
    public String addEvent(@RequestBody @Valid Event event){
        return eventService.addEvent(event);
    }

    //Add events
    @PostMapping("addEvents")
    public String addEvents(@RequestBody @Valid List<Event> events){
        return eventService.addEvents(events);
    }

    //Update event
    @PutMapping("updateEventById/{id}/location/{location}")
    public String updateEventById(@PathVariable Long id, @PathVariable String location){
        return eventService.addEventById(id, location);
    }

    //Delete event by id
    @DeleteMapping("deleteEventById/{id}")
    public String deleteEventById(@PathVariable Long id){
        return eventService.deleteEventById(id);
    }

    //Get all events
    @GetMapping("getAllEvents")
    public List<Event> getAllEvents(){
        return eventService.getAllEvents();
    }

    //Get all events by date
    @GetMapping("getAllEventsByDate/date/{date}")
    public List<Event> getAllEventsByDate(@PathVariable LocalDate date){
        return eventService.getAllEventsByDate(date);
    }
}

package com.geekster.UniversityEventManagement.service;

import com.geekster.UniversityEventManagement.model.Event;
import com.geekster.UniversityEventManagement.model.Student;
import com.geekster.UniversityEventManagement.repo.IEventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventService {
    @Autowired
    IEventRepo eventRepo;

    public String addEvent(Event event) {
        eventRepo.save(event);
        return event.getEventName() + " event saved!";
    }

    public String addEvents(List<Event> events) {
        eventRepo.saveAll(events);
        return events.size() + " events were added!";
    }

    public String addEventById(Long id, String location) {
        Event event = eventRepo.findById(id).orElse(null);
        if(event != null){
            event.setEventLocation(location);
            eventRepo.save(event);
            return event.getEventName() + "'s location changed!";
        }
        return "No event with the given id found..";
    }

    public String deleteEventById(Long id) {
        eventRepo.deleteById(id);
        return "Event deleted!";
    }

    public List<Event> getAllEvents() {
        return (List<Event>) eventRepo.findAll();
    }

    public List<Event> getAllEventsByDate(LocalDate date) {
        return eventRepo.findByEventDate(date);
    }
}

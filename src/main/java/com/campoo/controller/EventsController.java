package com.campoo.controller;


import com.campoo.model.Event;
import com.campoo.model.EventRepository;


import com.campoo.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("campoo/api/events")
public class EventsController {

    @Autowired
    private EventService eventService;
    private EventRepository eventRepo;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String getFirstInfo() {
        return "hello";
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Event getEventById(@PathVariable("id") Long id) {
        return eventService.getEvent(id);
    }

    @RequestMapping(value="/all", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Event> getAllEvents() {
        return eventRepo.findAll();
    }
}

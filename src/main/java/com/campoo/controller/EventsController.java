package com.campoo.controller;


import com.campoo.model.Event;
import com.campoo.model.EventRepository;


import com.campoo.model.User;
import com.campoo.model.UserRepository;
import com.campoo.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("campoo/api/events")
public class EventsController {

    @Autowired
    private EventService eventService;
    @Autowired
    private EventRepository eventRepo;
    @Autowired
    private UserRepository userRepo;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String getFirstInfo() {
        return "Projekt na przedmiot PROO2022. Autor: Dominik Nuszkiewicz E-mail:dknuszkiewicz@gmail.com";
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    Optional<Event> getEventById(@PathVariable("id") Long id) {
        return eventService.getEventById(id);

    }

    @RequestMapping(value="/all", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Event> getAllEvents() {
        return eventRepo.findAll();
    }



    @RequestMapping(value="/add", method=RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Event addEvent(@RequestBody Event event) {
            return eventService.addEvent(event);
    }
}

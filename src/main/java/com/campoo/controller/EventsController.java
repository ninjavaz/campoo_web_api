package com.campoo.controller;


import com.campoo.model.Event;
import com.campoo.service.EventService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("campoo/api/events")
public class EventsController {

    @Autowired
    private EventService eventService;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String getFirstInfo() {
        return "hello";
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Event getEventById(@PathVariable("id") Long id) {
        return eventService.getEvent(id);
    }
}

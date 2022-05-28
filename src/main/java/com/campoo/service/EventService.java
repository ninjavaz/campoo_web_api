package com.campoo.service;

import com.campoo.model.Event;
import com.campoo.model.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public Event getEvent(Long id){
        return eventRepository.getById(id);
    }
}

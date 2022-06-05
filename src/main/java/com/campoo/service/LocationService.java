package com.campoo.service;

import com.campoo.model.Event;
import com.campoo.model.Location;
import com.campoo.model.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public Optional<Location> getLocationByName(String name){
        return locationRepository.findById(name);
    }
}

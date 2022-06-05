package com.campoo.controller;

import com.campoo.model.*;
import com.campoo.service.EventService;
import com.campoo.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("campoo/api/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;
    @Autowired
    private LocationRepository locationRepo;


    @RequestMapping(value="/{name}", method = RequestMethod.GET)
    public @ResponseBody
    Optional<Location> getLocationByName(@PathVariable("name") String name) {
        return locationService.getLocationByName(name);
    }

    @RequestMapping(value="/all", method = RequestMethod.GET)
    public List<Location> getAllLocations() {
        return locationRepo.findAll();
    }

    @RequestMapping(value="/add", method=RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Location addLocation(@RequestBody Location location) {
        return locationRepo.save(location);
    }
}

package com.campoo.controller;

import com.campoo.model.Location;
import com.campoo.model.LocationRepository;
import com.campoo.model.User;
import com.campoo.model.UserRepository;
import com.campoo.service.LocationService;
import com.campoo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("campoo/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepo;

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Optional<User> getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    @RequestMapping(value="/all", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @RequestMapping(value="/add", method=RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public User addLocation(@RequestBody User user) {
        return userRepo.save(user);
    }
}

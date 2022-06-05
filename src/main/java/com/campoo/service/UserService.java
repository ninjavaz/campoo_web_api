package com.campoo.service;

import com.campoo.model.EventRepository;
import com.campoo.model.Location;
import com.campoo.model.User;
import com.campoo.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }
}

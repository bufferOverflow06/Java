package com.example.bus_booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bus_booking.model.User;
import com.example.bus_booking.repository.UserRepository;

@Service
public class UserService{

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user){
        if(userRepository.findByEmail(user.getEmail()).isPresent()){
            throw new RuntimeException("Email already registered");
        }
        return userRepository.save(user);
    }

}

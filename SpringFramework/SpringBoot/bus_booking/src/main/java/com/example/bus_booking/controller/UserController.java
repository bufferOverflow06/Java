package com.example.bus_booking.controller;

import com.example.bus_booking.model.User;
import com.example.bus_booking.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController{
    @Autowired
    private UserService UserService;

    @PostMapping("register")
    public ResponseEntity<User> register(@RequestBody User user){
        User newUser = UserService.registerUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
}

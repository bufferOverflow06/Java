package com.example.bus_booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bus_booking.entity.Agent;
import com.example.bus_booking.service.AgentService;

@RestController
@RequestMapping("/api/agents")
public class AgentController{

    @Autowired
    private AgentService agentService;

    @PostMapping
    public ResponseEntity<Agent> createAgent(@RequestBody Agent agent){
        return ResponseEntity.ok(agentService.createAgent(agent));
    }
}

package com.example.bus_booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bus_booking.entity.Agent;
import com.example.bus_booking.entity.User;
import com.example.bus_booking.repository.AgentRepository;
import com.example.bus_booking.repository.UserRepository;

@Service
public class AgentService{

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private UserRepository userRepository;

    public Agent createAgent(Agent agent){
        Long userId = agent.getUser().getId();
        User fullUser = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        // If Associated user as `AGENT` role
        if(!"AGENT".equalsIgnoreCase(fullUser.getRole())){
            throw new RuntimeException("User is not of role Agent");
        }

        agent.setUser(fullUser);

        return agentRepository.save(agent);
    }

}

package com.example.bus_booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bus_booking.entity.Agent;

public interface AgentRepository extends JpaRepository<Agent, Long>{

}

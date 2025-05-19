package com.example.bus_booking.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Agents{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long agentId;

    private String agencyName;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private Users user;

    @OneToMany(mappedBy = "agent")
    private List<Buses> buses;
}

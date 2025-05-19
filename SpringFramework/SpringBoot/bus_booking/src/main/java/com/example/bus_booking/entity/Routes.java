package com.example.bus_booking.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Routes{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long routeId;

    private String source;

    private String destination;

    private Float distance;

    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL)
    private List<Schedules> schedules;
}

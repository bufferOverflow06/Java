package com.example.bus_booking.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Schedules{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;

    private LocalDate date;

    private LocalTime time;

    @ManyToOne
    @JoinColumn(name = "bus_id", referencedColumnName = "busId")
    private Buses bus;

    @ManyToOne
    @JoinColumn(name = "route_id", referencedColumnName = "routeId")
    private Routes route;

    @OneToOne(mappedBy = "schedules")
    private Bookings bookings;
}

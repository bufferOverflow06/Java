package com.example.bus_booking.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Users{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String name;

    private String email;

    private String password;

    private String role;  // ADMIN, USER and AGENT

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Bookings bookings;
}

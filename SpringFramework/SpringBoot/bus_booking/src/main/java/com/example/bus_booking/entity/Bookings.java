package com.example.bus_booking.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Bookings{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    private Integer seatNo;

    private String status;

    @OneToOne
    @JoinColumn(name = "schedule_id", referencedColumnName = "scheduleId")
    private Schedules schedules;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private Users user;
}

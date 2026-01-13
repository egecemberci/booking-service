package com.example.booking_service.controller;

import com.example.booking_service.dto.bookingRequest;
import com.example.booking_service.model.booking;
import com.example.booking_service.repository.bookingRepository;
import com.example.booking_service.service.bookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class bookingController {

    @Autowired
    private bookingRepository repository;

    @Autowired
    private bookingService service;

    
    @PostMapping
    public booking createBooking(@RequestBody bookingRequest request) {
        return service.createBooking(request);
    }

    @GetMapping
    public List<booking> getAllBookings() {
        return service.getAllBookings();
    }

    @GetMapping("/user/{userId}")
    public List<booking> getBookingsByUser(String userId) {
        return repository.findByUserId(userId);
    }
}
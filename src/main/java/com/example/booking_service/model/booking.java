package com.example.booking_service.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
@Data
public class booking {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String userId;

    // --- THIS WAS MISSING ---
    // The Service was trying to call .setEventId(), but this line didn't exist.
    private String eventId; 
    // ------------------------

    // The Timeframe fields you asked for
    private LocalDateTime startTime; 
    private LocalDateTime endTime;

    private Double totalAmount;
    private String status; // "PENDING", "CONFIRMED", etc.
    
    private LocalDateTime bookingDate = LocalDateTime.now();
    
    // MANUAL SETTER (Just in case Lombok is acting slow)
    public void setEventId(String eventId) {
        this.eventId = eventId;
    }
}
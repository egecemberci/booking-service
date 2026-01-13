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

    private String eventId; 

    // Timeframes of when the booking is valid
    private LocalDateTime startTime; 
    private LocalDateTime endTime;

    private Double totalAmount;
    private String status;
    
    private LocalDateTime bookingDate = LocalDateTime.now();
    
    // manual setter to avoid weird undefined cases
    public void setEventId(String eventId) {
        this.eventId = eventId;
    }
}
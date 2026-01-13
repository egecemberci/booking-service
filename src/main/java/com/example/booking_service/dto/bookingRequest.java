package com.example.booking_service.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class bookingRequest {
    // This is the user making the booking
    private String userId;
    
    // This is the thing being booked (Room/Instructor/Gear)
    // You said you renamed this to bookingId
    private String bookingId; 
    
    private Double totalAmount;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    // MANUAL GETTERS (To fix the "Undefined" error)
    public String getBookingId() {
        return bookingId;
    }

    public String getUserId() {
        return userId;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }
    
    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }
}
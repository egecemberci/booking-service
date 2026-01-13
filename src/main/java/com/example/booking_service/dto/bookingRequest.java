package com.example.booking_service.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class bookingRequest {
    private String userId;

    private String bookingId; 
    
    private Double totalAmount;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    // manual getters to fix a weird case regarding undefined errors
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
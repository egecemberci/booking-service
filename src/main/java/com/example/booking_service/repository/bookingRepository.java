package com.example.booking_service.repository;

import com.example.booking_service.model.booking;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface bookingRepository extends JpaRepository<booking, String> {
    // This creates the magic SQL query: "SELECT * FROM bookings WHERE user_id = ?"
    List<booking> findByUserId(String userId);
}
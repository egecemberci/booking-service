package com.example.booking_service.service;

import com.example.booking_service.dto.bookingRequest;
import com.example.booking_service.model.booking;
import com.example.booking_service.repository.bookingRepository;
import jakarta.annotation.PostConstruct; // Needed for the initial data loader
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class bookingService {

    @Autowired
    private bookingRepository repository; 

    // --- MAIN LOGIC ---
    public booking createBooking(bookingRequest request) {
        
        // 1. Create the Database Object
        booking booking = new booking();
        
        // 2. Transfer Data (Request -> Database)
        booking.setUserId(request.getUserId());
        
        // Mapping input "bookingId" to database column "eventId"
        booking.setEventId(request.getBookingId()); 
        
        booking.setTotalAmount(request.getTotalAmount());
        booking.setStartTime(request.getStartTime());
        booking.setEndTime(request.getEndTime());
        
        // Set initial status
        booking.setStatus("PENDING");
        
        // Save the booking
        return repository.save(booking);
    }

    // --- HELPER METHODS ---

    public List<booking> getAllBookings() {
        return repository.findAll();
    }

    public booking getBookingById(String id) {
        return repository.findById(id).orElse(null);
    }

    // This fixes the error in your Controller
    public List<booking> getBookingsByUser(String userId) {
        return repository.findByUserId(userId);
    }

    // --- INITIAL DATA LOADER (Runs automatically on start) ---
    @PostConstruct
    public void initData() {
        // Only add data if the database is empty
        if (repository.count() == 0) {
            
            System.out.println("initial data gen (rooms, gear, instructors)");

            // 1. A ROOM
            booking room = new booking();
            room.setUserId("user-1");
            room.setEventId("Deluxe Room 404"); 
            room.setTotalAmount(450.00);
            room.setStartTime(LocalDateTime.now().plusDays(10));
            room.setEndTime(LocalDateTime.now().plusDays(15));
            room.setStatus("CONFIRMED");
            repository.save(room);

            // 2. SKI GEAR
            booking gear = new booking();
            gear.setUserId("user-1");
            gear.setEventId("Ski Set + Helmet");
            gear.setTotalAmount(60.00);
            gear.setStartTime(LocalDateTime.now().plusDays(11));
            gear.setEndTime(LocalDateTime.now().plusDays(11).plusHours(4));
            gear.setStatus("CONFIRMED");
            repository.save(gear);

            // 3. AN INSTRUCTOR
            booking instructor = new booking();
            instructor.setUserId("user-2");
            instructor.setEventId("Instructor Ali");
            instructor.setTotalAmount(120.00);
            instructor.setStartTime(LocalDateTime.now().plusDays(12));
            instructor.setEndTime(LocalDateTime.now().plusDays(12).plusHours(2));
            instructor.setStatus("PENDING");
            repository.save(instructor);
        }
    }
}
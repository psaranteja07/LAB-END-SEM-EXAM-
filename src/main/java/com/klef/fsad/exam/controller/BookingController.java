package com.klef.fsad.exam.controller;

import com.klef.fsad.exam.model.Booking;
import com.klef.fsad.exam.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/add")
    public ResponseEntity<?> addBooking(@RequestBody Booking booking) {
        try {
            Booking savedBooking = bookingService.addBooking(booking);
            return new ResponseEntity<>(savedBooking, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Error adding booking: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBooking(@PathVariable("id") Integer id) {
        try {
            bookingService.deleteBooking(id);
            return new ResponseEntity<>("Booking deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting booking: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

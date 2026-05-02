package com.klef.fsad.exam.service;

import com.klef.fsad.exam.model.Booking;
import com.klef.fsad.exam.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public Booking addBooking(Booking booking) {
        if (booking.getBookingId() == null) {
            throw new IllegalArgumentException("Booking ID must not be null");
        }
        return bookingRepository.save(booking);
    }

    public void deleteBooking(Integer bookingId) {
        bookingRepository.deleteById(bookingId);
    }
}

package com.erikandreasdev.ecotransportsystem.application.services;

import com.erikandreasdev.ecotransportsystem.application.ports.inbound.BookingService;
import com.erikandreasdev.ecotransportsystem.application.ports.outbound.BikeRepository;
import com.erikandreasdev.ecotransportsystem.application.ports.outbound.BookingRepository;
import com.erikandreasdev.ecotransportsystem.application.ports.outbound.UserRepository;
import com.erikandreasdev.ecotransportsystem.domain.exceptions.BikeNotFoundException;
import com.erikandreasdev.ecotransportsystem.domain.exceptions.BookingNotFoundException;
import com.erikandreasdev.ecotransportsystem.domain.exceptions.UserNotFoundException;
import com.erikandreasdev.ecotransportsystem.domain.entities.Bike;
import com.erikandreasdev.ecotransportsystem.domain.entities.Booking;
import com.erikandreasdev.ecotransportsystem.domain.entities.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class BookingServiceImpl implements BookingService {


    private final BookingRepository bookingRepository;
    private final BikeRepository bikeRepository;
    private final UserRepository userRepository;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository, BikeRepository bikeRepository,
                              UserRepository userRepository) {
        this.bookingRepository = bookingRepository;
        this.bikeRepository = bikeRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional  // Ensure atomicity
    public Booking createBooking(UUID bikeId, UUID userId) {
        // Fetch bike and user from repositories with custom exceptions
        Bike bike = bikeRepository.findById(bikeId)
                .orElseThrow(() -> new BikeNotFoundException(bikeId));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));

        // Validate bike availability
        if (!bike.isAvailable()) {
            throw new IllegalStateException("Bike with ID: " + bikeId + " is not available for booking.");
        }

        // Mark bike as unavailable and save to repository
        bike.setAvailable(false);
        bikeRepository.save(bike);

        // Create and save the new booking
        Booking booking = new Booking();
        booking.setBikeId(bikeId);
        booking.setUserId(userId);
        booking.setBookingTime(LocalDateTime.now());

        return bookingRepository.save(booking);
    }

    @Override
    @Transactional
    public void cancelBooking(UUID bookingId) {
        // Retrieve the booking and throw an exception if not found
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new BookingNotFoundException(bookingId));

        // Retrieve the associated bike
        Bike bike = bikeRepository.findById(booking.getBikeId())
                .orElseThrow(() -> new IllegalStateException("Bike not found for the booking with ID: " + bookingId));

        // Mark bike as available again and update in repository
        bike.setAvailable(true);
        bikeRepository.save(bike);

        // Delete the booking to complete the cancellation
        bookingRepository.delete(bookingId);
    }

}

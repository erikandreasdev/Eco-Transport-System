package com.erikandreasdev.ecotransportsystem.domain.service;

import com.erikandreasdev.ecotransportsystem.domain.model.Bike;
import com.erikandreasdev.ecotransportsystem.domain.model.Booking;
import com.erikandreasdev.ecotransportsystem.domain.model.User;
import com.erikandreasdev.ecotransportsystem.domain.repository.BikeRepository;
import com.erikandreasdev.ecotransportsystem.domain.repository.BookingRepository;
import com.erikandreasdev.ecotransportsystem.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class DomainBookingService implements BookingService {

    private final BikeRepository bikeRepository;
    private final UserRepository userRepository;
    private final BookingRepository bookingRepository;

    public DomainBookingService(BikeRepository bikeRepository,
                                UserRepository userRepository,
                                BookingRepository bookingRepository) {
        this.bikeRepository = bikeRepository;
        this.userRepository = userRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Optional<Booking> bookBike(UUID bikeId, UUID userId) {
        Optional<Bike> bikeOpt = bikeRepository.findById(bikeId);
        Optional<User> userOpt = userRepository.findById(userId);

        if (bikeOpt.isPresent() && userOpt.isPresent() && bikeOpt.get().isAvailable()) {
            Bike bike = bikeOpt.get();
            bike.setAvailable(false); // Update bike availability

            Booking booking = new Booking();
            booking.setBookingId(UUID.randomUUID());
            booking.setBikeId(bike.getId());
            booking.setUserId(userOpt.get().getId());
            booking.setBookingTime(LocalDateTime.now());

            bookingRepository.save(booking);
            bikeRepository.save(bike); // Persist updated bike

            return Optional.of(booking);
        }
        return Optional.empty();
    }

}

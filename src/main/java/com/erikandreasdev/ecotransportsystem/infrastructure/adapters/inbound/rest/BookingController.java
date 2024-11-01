package com.erikandreasdev.ecotransportsystem.infrastructure.adapters.inbound.rest;

import com.erikandreasdev.ecotransportsystem.domain.entities.Booking;
import com.erikandreasdev.ecotransportsystem.application.ports.inbound.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public Booking createBooking(@RequestParam UUID bikeId, @RequestParam UUID userId) {
        return bookingService.createBooking(bikeId, userId);
    }

    @DeleteMapping("/{id}")
    public void cancelBooking(@PathVariable UUID id) {
        bookingService.cancelBooking(id);
    }

}

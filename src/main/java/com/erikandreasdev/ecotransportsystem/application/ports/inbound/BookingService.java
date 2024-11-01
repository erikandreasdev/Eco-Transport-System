package com.erikandreasdev.ecotransportsystem.application.ports.inbound;

import com.erikandreasdev.ecotransportsystem.domain.entities.Booking;

import java.util.UUID;

public interface BookingService {

    Booking createBooking(UUID bikeId, UUID userId);
    void cancelBooking(UUID bookingId);
}

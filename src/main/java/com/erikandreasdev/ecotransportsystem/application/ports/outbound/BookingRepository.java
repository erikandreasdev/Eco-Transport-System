package com.erikandreasdev.ecotransportsystem.application.ports.outbound;

import com.erikandreasdev.ecotransportsystem.domain.entities.Booking;

import java.util.Optional;
import java.util.UUID;

public interface BookingRepository {

    Optional<Booking> findById(UUID id);

    Booking save(Booking booking);

    void delete(UUID bookingId);

}
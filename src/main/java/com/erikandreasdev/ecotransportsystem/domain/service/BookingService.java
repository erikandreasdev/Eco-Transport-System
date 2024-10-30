package com.erikandreasdev.ecotransportsystem.domain.service;

import com.erikandreasdev.ecotransportsystem.domain.model.Booking;

import java.util.Optional;
import java.util.UUID;

public interface BookingService {

    Optional<Booking> bookBike(UUID bikeId, UUID userId);

}

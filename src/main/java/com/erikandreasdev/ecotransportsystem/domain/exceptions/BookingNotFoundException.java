package com.erikandreasdev.ecotransportsystem.domain.exceptions;

import java.util.UUID;

public class BookingNotFoundException extends RuntimeException {

    public BookingNotFoundException(UUID bookingId) {
        super("Booking not found with ID: " + bookingId);
    }

}

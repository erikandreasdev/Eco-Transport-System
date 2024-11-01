package com.erikandreasdev.ecotransportsystem.domain.exceptions;

import java.util.UUID;

public class BikeNotFoundException extends RuntimeException {

    public BikeNotFoundException(UUID bikeId) {
        super("Bike not found with ID: " + bikeId);
    }

}

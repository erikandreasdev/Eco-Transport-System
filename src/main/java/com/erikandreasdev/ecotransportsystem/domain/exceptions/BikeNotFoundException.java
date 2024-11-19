package com.erikandreasdev.ecotransportsystem.domain.exceptions;

public class BikeNotFoundException extends RuntimeException {

    public BikeNotFoundException(Long id) {
        super("Bike with ID " + id + " not found");
    }

}

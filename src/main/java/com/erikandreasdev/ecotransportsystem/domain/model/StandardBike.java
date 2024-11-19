package com.erikandreasdev.ecotransportsystem.domain.model;

public class StandardBike extends Bike {

    public StandardBike() {
        super(BikeType.STANDARD, 5.0);
    }

    public StandardBike(BikeType bikeType, double pricePerHour) {
        super(bikeType, pricePerHour);
    }

}

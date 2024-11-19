package com.erikandreasdev.ecotransportsystem.domain.model;

public class MountainBike extends Bike{

    public MountainBike() {
        super(BikeType.MOUNTAIN, 8.0);
    }

    public MountainBike(BikeType bikeType, double pricePerHour) {
        super(bikeType, pricePerHour);
    }
}

package com.erikandreasdev.ecotransportsystem.domain.model;

public class ElectricBike extends Bike {

    public ElectricBike() {
        super(BikeType.ELECTRIC, 12.5);
    }

    public ElectricBike(BikeType bikeType, double pricePerHour) {
        super(bikeType, pricePerHour);
    }

}

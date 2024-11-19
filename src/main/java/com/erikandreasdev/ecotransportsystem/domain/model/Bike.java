package com.erikandreasdev.ecotransportsystem.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Bike {

    private BikeType bikeType;

    private double pricePerHour;

}

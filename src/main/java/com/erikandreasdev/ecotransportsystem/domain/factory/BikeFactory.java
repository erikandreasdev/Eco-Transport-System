package com.erikandreasdev.ecotransportsystem.domain.factory;

import com.erikandreasdev.ecotransportsystem.domain.model.*;
import org.springframework.stereotype.Component;

@Component
public class BikeFactory {

    public Bike get(BikeType bikeType) {
        if (bikeType == null) return null;
        return switch (bikeType) {
            case STANDARD -> new StandardBike();
            case ELECTRIC -> new ElectricBike();
            case MOUNTAIN -> new MountainBike();
        };
    }
}

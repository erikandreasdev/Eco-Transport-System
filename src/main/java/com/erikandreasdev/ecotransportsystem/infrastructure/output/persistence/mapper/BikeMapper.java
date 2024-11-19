package com.erikandreasdev.ecotransportsystem.infrastructure.output.persistence.mapper;

import com.erikandreasdev.ecotransportsystem.domain.model.*;
import com.erikandreasdev.ecotransportsystem.infrastructure.input.rest.response.BikeResponse;
import com.erikandreasdev.ecotransportsystem.infrastructure.output.persistence.entities.BikeEntity;
import org.springframework.stereotype.Component;

@Component
public class BikeMapper {

    public BikeEntity toEntity(Bike bike) {
        if (bike == null) {
            return null;
        }
        BikeEntity bikeEntity = new BikeEntity();
        bikeEntity.setType(bike.getBikeType());
        bikeEntity.setPrice(bike.getPricePerHour());
        bikeEntity.setAvailable(true);
        return bikeEntity;
    }

    public Bike toModel(BikeEntity bikeEntity) {
        if (bikeEntity == null) {
            return null;
        }
        return switch (bikeEntity.getType()) {
            case STANDARD -> new StandardBike(bikeEntity.getType(), bikeEntity.getPrice());
            case ELECTRIC -> new ElectricBike(bikeEntity.getType(), bikeEntity.getPrice());
            case MOUNTAIN -> new MountainBike(bikeEntity.getType(), bikeEntity.getPrice());
        };
    }

    public BikeResponse toResponse(BikeEntity bikeEntity) {
        return new BikeResponse(bikeEntity.getId(),
                                bikeEntity.getType(),
                                bikeEntity.getPrice(),
                                bikeEntity.getAvailable());
    }

}

package com.erikandreasdev.ecotransportsystem.application.ports.outbound;

import com.erikandreasdev.ecotransportsystem.domain.entities.Bike;

import java.util.Optional;
import java.util.UUID;

public interface BikeRepository {

    Optional<Bike> findById(UUID bikeId);

    void save(Bike bike);

    void deleteById(UUID bikeId);

}
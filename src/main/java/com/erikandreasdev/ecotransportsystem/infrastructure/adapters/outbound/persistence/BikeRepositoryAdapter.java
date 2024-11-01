package com.erikandreasdev.ecotransportsystem.infrastructure.adapters.outbound.persistence;

import com.erikandreasdev.ecotransportsystem.application.ports.outbound.BikeRepository;
import com.erikandreasdev.ecotransportsystem.domain.entities.Bike;
import com.erikandreasdev.ecotransportsystem.infrastructure.adapters.outbound.Jpa.BikeJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class BikeRepositoryAdapter implements BikeRepository {

    private final BikeJpaRepository repository;

    public BikeRepositoryAdapter(BikeJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Bike> findById(UUID bikeId) {
        return repository.findById(bikeId);
    }

    @Override
    public void save(Bike bike) {
        repository.save(bike);
    }

    @Override
    public void deleteById(UUID bikeId) {

    }

}

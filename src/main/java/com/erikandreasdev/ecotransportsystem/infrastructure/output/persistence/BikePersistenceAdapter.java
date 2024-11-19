package com.erikandreasdev.ecotransportsystem.infrastructure.output.persistence;

import com.erikandreasdev.ecotransportsystem.application.output.BikePersistence;
import com.erikandreasdev.ecotransportsystem.domain.exceptions.BikeNotFoundException;
import com.erikandreasdev.ecotransportsystem.domain.model.Bike;
import com.erikandreasdev.ecotransportsystem.infrastructure.input.rest.response.BikeResponse;
import com.erikandreasdev.ecotransportsystem.infrastructure.output.persistence.entities.BikeEntity;
import com.erikandreasdev.ecotransportsystem.infrastructure.output.persistence.mapper.BikeMapper;
import com.erikandreasdev.ecotransportsystem.infrastructure.output.persistence.repository.BikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BikePersistenceAdapter implements BikePersistence {

    private final BikeRepository bikeRepository;
    private final BikeMapper bikeMapper;

    @Override
    public void deleteById(Long id) {
        bikeRepository.deleteById(id);
    }

    @Override
    public List<BikeResponse> list() {
        return bikeRepository.findAll().stream().map(bikeMapper::toResponse).toList();
    }

    @Override
    public BikeResponse findById(Long id) {
        return bikeRepository
                .findById(id)
                .map(bikeMapper::toResponse)
                .orElseThrow(() -> new BikeNotFoundException(id));
    }

    @Override
    public void save(Bike bike) {
        BikeEntity bikeEntity = bikeMapper.toEntity(bike);
        BikeEntity savedBikeEntity = bikeRepository.save(bikeEntity);
        bikeMapper.toModel(savedBikeEntity);
    }

}

package com.erikandreasdev.ecotransportsystem.domain.service;

import com.erikandreasdev.ecotransportsystem.application.input.bike.AddBikeToStock;
import com.erikandreasdev.ecotransportsystem.application.input.bike.BikeStock;
import com.erikandreasdev.ecotransportsystem.application.input.bike.RemoveBikeFromStock;
import com.erikandreasdev.ecotransportsystem.application.output.BikePersistence;
import com.erikandreasdev.ecotransportsystem.domain.factory.BikeFactory;
import com.erikandreasdev.ecotransportsystem.domain.model.Bike;
import com.erikandreasdev.ecotransportsystem.domain.model.BikeType;
import com.erikandreasdev.ecotransportsystem.infrastructure.input.rest.response.BikeResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BikeStockService implements AddBikeToStock, RemoveBikeFromStock, BikeStock {

    private final BikeFactory bikeFactory;

    private final BikePersistence bikePersistence;

    @Override
    public List<BikeResponse> list() {
        return bikePersistence.list();
    }

    @Override
    public BikeResponse findById(Long id) {
        return bikePersistence.findById(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        bikePersistence.deleteById(id);
    }

    @Override
    @Transactional
    public void add(BikeType bikeType) {
        Bike bike = bikeFactory.get(bikeType);
        Objects.requireNonNull(bike, "Bike must not be null");
        bikePersistence.save(bike);
    }

}

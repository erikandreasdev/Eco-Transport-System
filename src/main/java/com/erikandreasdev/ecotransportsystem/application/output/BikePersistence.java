package com.erikandreasdev.ecotransportsystem.application.output;

import com.erikandreasdev.ecotransportsystem.domain.model.Bike;
import com.erikandreasdev.ecotransportsystem.infrastructure.input.rest.response.BikeResponse;

import java.util.List;

public interface BikePersistence {

    void save(Bike bike);

    void deleteById(Long id);

    List<BikeResponse> list();

    BikeResponse findById(Long id);

}

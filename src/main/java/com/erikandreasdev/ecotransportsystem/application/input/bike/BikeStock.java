package com.erikandreasdev.ecotransportsystem.application.input.bike;

import com.erikandreasdev.ecotransportsystem.infrastructure.input.rest.response.BikeResponse;

import java.util.List;

public interface BikeStock {

    List<BikeResponse> list();

    BikeResponse findById(Long id);

}

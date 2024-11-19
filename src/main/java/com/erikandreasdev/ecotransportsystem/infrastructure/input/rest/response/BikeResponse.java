package com.erikandreasdev.ecotransportsystem.infrastructure.input.rest.response;

import com.erikandreasdev.ecotransportsystem.domain.model.BikeType;

public record BikeResponse(Long id, BikeType type, Double pricePerHour, Boolean available) {

}

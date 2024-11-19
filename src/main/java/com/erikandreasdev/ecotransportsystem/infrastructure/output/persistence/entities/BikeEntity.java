package com.erikandreasdev.ecotransportsystem.infrastructure.output.persistence.entities;

import com.erikandreasdev.ecotransportsystem.domain.model.BikeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class BikeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BikeType type;

    private Double price;

    private Boolean available;

}

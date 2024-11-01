package com.erikandreasdev.ecotransportsystem.infrastructure.adapters.outbound.Jpa;

import com.erikandreasdev.ecotransportsystem.domain.entities.Bike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BikeJpaRepository extends JpaRepository<Bike, UUID> {

}

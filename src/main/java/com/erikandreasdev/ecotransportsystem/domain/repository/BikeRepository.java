package com.erikandreasdev.ecotransportsystem.domain.repository;

import com.erikandreasdev.ecotransportsystem.domain.model.Bike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BikeRepository extends JpaRepository<Bike, UUID> {
}
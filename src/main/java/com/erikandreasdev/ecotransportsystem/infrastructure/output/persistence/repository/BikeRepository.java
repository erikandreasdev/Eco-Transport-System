package com.erikandreasdev.ecotransportsystem.infrastructure.output.persistence.repository;

import com.erikandreasdev.ecotransportsystem.infrastructure.output.persistence.entities.BikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BikeRepository extends JpaRepository<BikeEntity, Long> {

}

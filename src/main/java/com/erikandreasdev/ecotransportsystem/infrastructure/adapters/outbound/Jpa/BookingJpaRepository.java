package com.erikandreasdev.ecotransportsystem.infrastructure.adapters.outbound.Jpa;

import com.erikandreasdev.ecotransportsystem.domain.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookingJpaRepository extends JpaRepository<Booking, UUID> {

}
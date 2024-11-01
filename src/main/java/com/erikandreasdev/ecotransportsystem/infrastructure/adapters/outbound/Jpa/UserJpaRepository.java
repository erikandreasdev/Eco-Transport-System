package com.erikandreasdev.ecotransportsystem.infrastructure.adapters.outbound.Jpa;

import com.erikandreasdev.ecotransportsystem.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserJpaRepository extends JpaRepository<User, UUID> {

}

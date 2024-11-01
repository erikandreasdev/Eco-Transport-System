package com.erikandreasdev.ecotransportsystem.application.ports.outbound;

import com.erikandreasdev.ecotransportsystem.domain.entities.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {

    Optional<User> findById(UUID userId);

}
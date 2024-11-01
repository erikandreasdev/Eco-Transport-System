package com.erikandreasdev.ecotransportsystem.infrastructure.adapters.outbound.persistence;

import com.erikandreasdev.ecotransportsystem.application.ports.outbound.UserRepository;
import com.erikandreasdev.ecotransportsystem.domain.entities.User;
import com.erikandreasdev.ecotransportsystem.infrastructure.adapters.outbound.Jpa.UserJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepositoryAdapter implements UserRepository {

    private final UserJpaRepository repository;

    public UserRepositoryAdapter(UserJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void delete(UUID userId) {
        repository.deleteById(userId);
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public Optional<User> findById(UUID userId) {
        return repository.findById(userId);
    }

}

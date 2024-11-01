package com.erikandreasdev.ecotransportsystem.infrastructure.adapters.outbound.persistence;

import com.erikandreasdev.ecotransportsystem.application.ports.outbound.BookingRepository;
import com.erikandreasdev.ecotransportsystem.domain.entities.Booking;
import com.erikandreasdev.ecotransportsystem.infrastructure.adapters.outbound.Jpa.BookingJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class BookingRepositoryAdapter implements BookingRepository {

    private final BookingJpaRepository repository;

    public BookingRepositoryAdapter(BookingJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Booking> findById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public Booking save(Booking booking) {
        return repository.save(booking);
    }

    @Override
    public void delete(UUID bookingId) {
        repository.deleteById(bookingId);
    }

}

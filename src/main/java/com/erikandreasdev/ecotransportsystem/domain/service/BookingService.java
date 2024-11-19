package com.erikandreasdev.ecotransportsystem.domain.service;

import com.erikandreasdev.ecotransportsystem.application.input.BookBike;
import com.erikandreasdev.ecotransportsystem.application.input.ReturnBike;
import com.erikandreasdev.ecotransportsystem.application.input.bike.BikeStock;
import com.erikandreasdev.ecotransportsystem.application.output.BookingRepository;
import com.erikandreasdev.ecotransportsystem.domain.model.Bike;
import org.springframework.stereotype.Service;

@Service
public class BookingService implements BookBike, ReturnBike {

    private BookingRepository bookingRepository;

    @Override
    public Bike bookBike() {
        return null;
    }

    @Override
    public void returnBike() {

    }

}

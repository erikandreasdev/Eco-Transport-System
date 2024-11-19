package com.erikandreasdev.ecotransportsystem.domain.service;

import com.erikandreasdev.ecotransportsystem.application.output.BikePersistence;
import com.erikandreasdev.ecotransportsystem.domain.model.Bike;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.EmptyResultDataAccessException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class BikeStockServiceTest {

    @Autowired
    private BikeStockService bikeStockService;

    @MockBean
    private BikePersistence bikePersistence;

    @Test
    void testAddBike() {
        Bike bike = mock(Bike.class);
        bikeStockService.add(bike);
        verify(bikePersistence, times(1)).save(any(Bike.class));
    }

    @Test
    void testAddNullBike() {
        Exception exception = Assertions.assertThrows(NullPointerException.class, () -> {
            bikeStockService.add(null);
        });
        String expectedMessage = "Bike must not be null";
        String actualMessage = exception.getMessage();
        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testDeleteBike() {
        doNothing().when(bikePersistence).deleteById(any(Long.class));
        bikeStockService.delete(1L);
        verify(bikePersistence, times(1)).deleteById(any(Long.class));
    }

    @Test
    void testDeleteNotExistingBike() {
        doThrow(EmptyResultDataAccessException.class)
                .when(bikePersistence)
                .deleteById(any(Long.class));
        Exception
                exception
                = Assertions.assertThrows(EmptyResultDataAccessException.class,
                                          () -> {
                                              bikeStockService.delete(1L);
                                          });
        Assertions.assertTrue(exception instanceof EmptyResultDataAccessException);
    }

}
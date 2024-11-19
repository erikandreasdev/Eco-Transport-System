package com.erikandreasdev.ecotransportsystem.infrastructure.input.rest;

import com.erikandreasdev.ecotransportsystem.application.input.bike.AddBikeToStock;
import com.erikandreasdev.ecotransportsystem.application.input.bike.BikeStock;
import com.erikandreasdev.ecotransportsystem.application.input.bike.RemoveBikeFromStock;
import com.erikandreasdev.ecotransportsystem.domain.exceptions.BikeNotFoundException;
import com.erikandreasdev.ecotransportsystem.domain.model.Bike;
import com.erikandreasdev.ecotransportsystem.domain.model.BikeType;
import com.erikandreasdev.ecotransportsystem.infrastructure.input.rest.response.BikeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bikes")
@RequiredArgsConstructor
public class BikeStockController {

    private final BikeStock bikeStock;

    private final AddBikeToStock addBikeToStock;

    private final RemoveBikeFromStock removeBikeFromStock;

    @GetMapping("")
    public ResponseEntity<List<BikeResponse>> listAllBikes() {
        return ResponseEntity.ok(bikeStock.list());
    }
    @GetMapping("/{id}")
    public ResponseEntity<BikeResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(bikeStock.findById(id));
    }

    @PostMapping("")
    public void addBikeToStock(@RequestParam(name = "type") BikeType bikeType) {
        addBikeToStock.add(bikeType);
    }

    @DeleteMapping("/{id}")
    public void removeBikeFromStock(@PathVariable Long id) {
        removeBikeFromStock.delete(id);
    }

    @ExceptionHandler(BikeNotFoundException.class)
    public ResponseEntity<String> handleBikeNotFoundException(BikeNotFoundException exception) {
        return ResponseEntity.status(404).body(exception.getMessage());
    }
}

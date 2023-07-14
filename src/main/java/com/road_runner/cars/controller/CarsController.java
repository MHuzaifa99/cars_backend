package com.road_runner.cars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.road_runner.cars.model.Cars;
import com.road_runner.cars.repository.ICars;

@CrossOrigin("*")
@RestController
@RequestMapping("/cars")
public class CarsController {
    @Autowired
    public ICars carsRepo;

    @PostMapping("/add")
    public ResponseEntity<Cars> addCar(@RequestBody Cars car){
        return ResponseEntity.ok().body(carsRepo.save(car)); 
    }

    @GetMapping("/get")
    public ResponseEntity<List<Cars>> getCar(){
        return ResponseEntity.ok().body(carsRepo.findAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Cars> getById(@PathVariable long id){
        return ResponseEntity.ok().body(carsRepo.findById(id).orElse(null));
    }
}

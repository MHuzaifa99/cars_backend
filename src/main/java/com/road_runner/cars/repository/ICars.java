package com.road_runner.cars.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.road_runner.cars.model.Cars;

public interface ICars extends JpaRepository<Cars, Long>{
    
}

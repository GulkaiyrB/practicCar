package com.example.firstJWTprojectItAcad.repository;

import com.example.firstJWTprojectItAcad.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
    Car findByUserId(Long id);
    Car findByModel(String model);

    @Query("SELECT MAX(consume) FROM Car")
    Car findByMaxConsume();
    @Query("SELECT MAX(maxSpeed) FROM Car")
    Car findByMaxSpeed();
}

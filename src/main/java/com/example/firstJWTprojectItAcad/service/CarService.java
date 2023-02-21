package com.example.firstJWTprojectItAcad.service;

import com.example.firstJWTprojectItAcad.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.firstJWTprojectItAcad.repository.CarRepository;

import java.util.List;
@Service
public class CarService {
    private final CarRepository carRepo;

    @Autowired
    public CarService(CarRepository carRepo) {
        this.carRepo = carRepo;
    }

    public List<Car> getCars() {
        return carRepo.findAll();
    }

    public Car getByUser(Long userId) {
        return carRepo.findByUserId(userId);
    }

    public Car getByModel(String model) {
        return carRepo.findByModel(model);
    }
//    public Car getMaxConsuming(){
//        List<Car> cars = carRepo.findAll();
//        return cars.stream().max();
//    }

//    public Car getFastestCar(){
//        List<Car> cars = carRepo.findAll();
//        return cars.stream()
//                .mapToDouble(v -> v.getConsume())
//                .max().orElseThrow(null);
//    }

    public Car findByMaxConsume() {
        return carRepo.findByMaxConsume();
    }

    public Car findByMaxSpeed() {
        return carRepo.findByMaxSpeed();
    }
}

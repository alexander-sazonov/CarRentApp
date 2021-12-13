package com.innopolis.carrentapp.service;

import com.innopolis.carrentapp.model.Car;
import com.innopolis.carrentapp.model.Location;

import java.util.List;
import java.util.UUID;

public interface CarService {
    Car getById(UUID id);
    List<Car> getAll();
    Car createCar(Car car);
    Car updateCar(UUID id, Car car);
    void delete(UUID id);
    List<Car> findByLocation(Location location);
}

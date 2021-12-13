package com.innopolis.carrentapp.service;

import com.innopolis.carrentapp.model.Car;
import com.innopolis.carrentapp.model.Location;
import com.innopolis.carrentapp.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class CarDatabaseService implements CarService{

    private final CarRepository carRepository;

    @Override
    public Car getById(UUID id) {
        return carRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,format("Car with id %d not found",id)));
    }

    @Override
    public List<Car> getAll() {
        Iterable<Car> carIterable = carRepository.findAll();
        List<Car> carsList = new ArrayList<>();
        carIterable.forEach(carsList::add);
        return carsList;
    }

    @Override
    public Car createCar(Car car) {
        car.setId(UUID.randomUUID());
        return carRepository.save(car);
    }

    @Override
    public Car updateCar(UUID id, Car car) {
        Car carFromDb = getById(id);
        Car carToUpdate = carFromDb.toBuilder().regNumber(car.getRegNumber())
                .manufacturer(car.getManufacturer())
                .model(car.getModel())
                .seatCapacity(car.getSeatCapacity())
                .typeTransmission(car.getTypeTransmission())
                .rentPerDay(car.getRentPerDay())
                .build();
        return carRepository.save(carToUpdate);
    }

    @Override
    public void delete(UUID id) {
        carRepository.deleteById(id);
    }

    @Override
    public List<Car> findByLocation(Location location) {
        return carRepository.findCarByLocation(location);
    }
}

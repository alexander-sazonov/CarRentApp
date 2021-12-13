package com.innopolis.carrentapp.repository;

import com.innopolis.carrentapp.model.Car;
import com.innopolis.carrentapp.model.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CarRepository extends CrudRepository<Car, UUID> {
    List<Car> findCarByLocation(Location location);
}

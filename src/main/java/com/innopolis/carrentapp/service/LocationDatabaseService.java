package com.innopolis.carrentapp.service;

import com.innopolis.carrentapp.model.Location;
import com.innopolis.carrentapp.repository.LocationRepository;
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
public class LocationDatabaseService implements LocationService{

    private final LocationRepository locationRepository;

    @Override
    public Location getById(UUID id) {
        return locationRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,format("Location with id %d not found",id)));
    }

    @Override
    public List<Location> getAll() {
        Iterable<Location> locationIterable = locationRepository.findAll();
        List<Location> locationsList = new ArrayList<>();
        locationIterable.forEach(locationsList::add);
        return locationsList;
    }

    @Override
    public Location createLocation(Location location) {
        location.setId(UUID.randomUUID());
        return locationRepository.save(location);
    }

    @Override
    public Location updateLocation(UUID id, Location location) {
        Location locationFromDb = getById(id);
        Location locationToUpdate =locationFromDb.toBuilder()
                .country(location.getCountry())
                .city(location.getCity())
                .address(location.getAddress())
                .email(location.getEmail())
                .phone(location.getPhone())
                .build();
        return locationRepository.save(locationToUpdate);
    }

    @Override
    public void delete(UUID id) {
        locationRepository.deleteById(id);

    }
}

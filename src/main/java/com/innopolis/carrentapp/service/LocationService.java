package com.innopolis.carrentapp.service;



import com.innopolis.carrentapp.model.Location;

import java.util.List;
import java.util.UUID;

public interface LocationService {
    Location getById(UUID id);
    List<Location> getAll();
    Location createLocation(Location location);
    Location updateLocation(UUID id, Location location);
    void delete(UUID id);
}

package com.innopolis.carrentapp.repository;

import com.innopolis.carrentapp.model.Location;
import org.springframework.data.repository.CrudRepository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.UUID;

public interface LocationRepository extends CrudRepository<Location, UUID> {
    List<Location> findByCountry(String country);
}

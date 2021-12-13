package com.innopolis.carrentapp.controller;

import com.innopolis.carrentapp.model.Location;
import com.innopolis.carrentapp.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/ui/locations")
public class LocationFrontendController {

    private final LocationService locationService;

    @GetMapping
    public String locationsPage(Model model){
        List<Location> locations = locationService.getAll();
        model.addAttribute("locations", locations);
        return "locations/locations";
    }

    @GetMapping("/{id}")
    public String locationPage(Model model, @PathVariable UUID id) {
        Location location = locationService.getById(id);
        model.addAttribute("location", location);
        return "locations/location";
    }


    @GetMapping("/new")
    public String locationCreatePage(Model model) {
        model.addAttribute("location", new Location());
        return "locations/location";
    }


    @PostMapping
    public String createOrUpdateLocation(@ModelAttribute("locationDto") Location locationDto){
        if(locationDto.getId() == null){
            locationService.createLocation(locationDto);
        } else{
            locationService.updateLocation(locationDto.getId(),locationDto);
        }
        return "redirect:/ui/locations";
    }

    @PostMapping("/delete/{id}")
    public String deleteLocation(@PathVariable UUID id) {
        locationService.delete(id);
        return "redirect:/ui/locations";
    }





}

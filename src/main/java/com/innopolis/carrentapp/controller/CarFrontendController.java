package com.innopolis.carrentapp.controller;

import com.innopolis.carrentapp.model.Car;
import com.innopolis.carrentapp.model.Location;
import com.innopolis.carrentapp.model.TypeTransmission;
import com.innopolis.carrentapp.service.CarService;
import com.innopolis.carrentapp.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/ui/cars")
public class CarFrontendController {

    private final CarService carService;
    private final LocationService locationService;

    @GetMapping
    public String carsPage(Model model){
        List<Car> cars = carService.getAll();
        model.addAttribute("cars", cars);
        return "cars/cars";
    }

    @GetMapping("/{id}")
    public String carPage(Model model, @PathVariable UUID id) {
        Car car  = carService.getById(id);
        List<Location> locations = locationService.getAll();
        model.addAttribute("car", car);
        model.addAttribute("transmissionTypes", TypeTransmission.values());
        model.addAttribute("locations",locations);
        return "cars/car";
    }

    @GetMapping("/new")
    public String newCarPage(Model model){
        Car car = new Car();
        List<Location> locations = locationService.getAll();
        car.setTypeTransmission(TypeTransmission.AUTOMATIC);
        model.addAttribute("car",car);
        model.addAttribute("transmissionTypes", TypeTransmission.values());
        model.addAttribute("locations",locations);
        return "cars/car";
    }

    @PostMapping
    public String createOrUpdateCar(@ModelAttribute("carDto") Car carDto){
        if(carDto.getId() == null){
            carService.createCar(carDto);
        } else {
            carService.updateCar(carDto.getId(),carDto);
        }
        return "redirect:/ui/cars";
    }

    @PostMapping("/delete/{id}")
    public String deleteCar(@PathVariable UUID id) {
        carService.delete(id);
        return "redirect:/ui/cars";
    }
}

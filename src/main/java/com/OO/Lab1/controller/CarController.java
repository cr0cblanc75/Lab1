package com.OO.Lab1.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.OO.Lab1.obj.Car;
import com.OO.Lab1.services.CarService;

@RestController
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    @ResponseStatus(HttpStatus.OK)
    public List<Car> getCars(
            @RequestParam(value = "available", required = false) String available) {

        if (available != null) {
            return carService.getAvailableCars();
        }
        return carService.getAllCars();
    }

    @GetMapping("/cars/{plateNumber}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Car getCarbyPlateNumber(
            @PathVariable("plateNumber") String plateNumber,
            @RequestParam(value = "toRent", required = false) String toRent,
            @RequestParam(value = "toReturn", required = false) String toReturn) throws Exception {

        if (toRent != null && toReturn == null) {
            carService.rentCar(plateNumber);

        } else if (toReturn != null && toRent == null) {
            carService.returnCar(plateNumber);

        } else {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Invalid request parameters. Please specify either 'toRent' or 'toReturn'."
            );
        }

        return carService.getCarbyPlateNumber(plateNumber);
    }
}

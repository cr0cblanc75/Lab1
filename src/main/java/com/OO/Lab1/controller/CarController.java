package com.OO.Lab1.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/cars/{plateNumber}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Car getCarbyPlateNumber(@PathVariable("plateNumber") String plateNumber) throws Exception {
        return carService.getCarbyPlateNumber(plateNumber);
    }

    @GetMapping("/cars?available=true")
    @ResponseStatus(HttpStatus.OK)
    public List<Car> getAvailableCars() {
        return carService.getAvailableCars();
    }

    /* 
    @PutMapping("/cars/{plateNumber}")
    @ResponseStatus(HttpStatus.OK)
    public void rentOrGetBack(
            @PathVariable("plateNumber") String plateNumber,
            @RequestParam(value = "rent", required = true) boolean rent,
            @RequestBody(required = false) Dates dates) {

        if (rent) {
            System.out.println("Car " + plateNumber + " rented");
            System.out.println("Begin: " + dates.getBegin());
            System.out.println("End: " + dates.getEnd());
        } else {
            System.out.println("Car " + plateNumber + " returned");
        }
    } 
     */
}

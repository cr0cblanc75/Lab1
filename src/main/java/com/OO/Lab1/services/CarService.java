package com.OO.Lab1.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.OO.Lab1.obj.Car;

@Service
public class CarService {

    private List<Car> cars = new ArrayList<>();

    public CarService() {
        cars.add(new Car("0", "Ferrari", 100));
        cars.add(new Car("1", "Porsche", 150));
        cars.add(new Car("2", "BMW", 200));
        cars.add(new Car("3", "Audi", 20));
    }

    public List<Car> getAllCars() {
        return cars;
    }

    public Car getCarbyPlateNumber(@PathVariable("plateNumber") String plateNumber) throws Exception {
        for (Car car : cars) {
            if (car.getPlateNumber().equals(plateNumber)) {
                return car;
            }
        }
        return null;
    }

    public List<Car> getAvailableCars() {
        List<Car> availableCars = new ArrayList<>();

        for (Car car : cars) {
            if (!car.isRented()) {
                availableCars.add(car);
            }
        }
        return availableCars;
    }

    public void rentCar(String plateNumber) throws Exception {
        Car car = getCarbyPlateNumber(plateNumber);
        if (car != null && !car.isRented()) {
            car.confirmRented();
        } else {
            throw new Exception("Car not available for rent.");
        }
    }

}

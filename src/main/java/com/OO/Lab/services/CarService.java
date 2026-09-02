package com.OO.Lab.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.OO.Lab.obj.Car;

@Service
public class CarService {

    private final List<Car> cars = new ArrayList<>();

    public CarService() {
        cars.add(new Car("0", "Ferrari", 100));
        cars.add(new Car("1", "Porsche", 150));
        cars.add(new Car("2", "BMW", 200));
        cars.add(new Car("3", "Audi", 20));
    }

    // GET ALL THE CARS
    public List<Car> getAllCars() {
        return cars;
    }

    // GET ONLY THE DESIRED CAR
    public Car getCarbyPlateNumber(@PathVariable("plateNumber") String plateNumber) throws Exception {
        for (Car car : cars) {
            if (car.getPlateNumber().equals(plateNumber)) {
                return car;
            }
        }
        throw new Exception("Car with plate number '" + plateNumber + "' not found.");
    }

    // GET ALL THE AVAILABLE CARS
    public List<Car> getAvailableCars() {
        List<Car> availableCars = new ArrayList<>();

        for (Car car : cars) {
            if (!car.isRented()) {
                availableCars.add(car);
            }
        }
        return availableCars;
    }

    // RENT A CAR
    public void rentCar(String plateNumber) throws Exception {
        Car car = getCarbyPlateNumber(plateNumber);
        if (car != null && !car.isRented()) {
            car.confirmRented();
        } else {
            throw new Exception("Car not available for rent.");
        }
    }

    // RETURN A CAR
    public void returnCar(String plateNumber) throws Exception {
        Car car = getCarbyPlateNumber(plateNumber);
        if (car != null && car.isRented()) {
            car.confirmReturned();
        } else {
            throw new Exception("Car not available for return.");
        }
    }

}

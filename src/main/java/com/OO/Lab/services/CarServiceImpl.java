package com.OO.Lab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OO.Lab.bdd.Car;
import com.OO.Lab.bdd.CarRepository;

import jakarta.annotation.PostConstruct;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @PostConstruct // to build this ater the setting up of the class
    public void init() {
        carRepository.save(new Car("0", "Ferrari", 100));
        carRepository.save(new Car("1", "Porsche", 150));
        carRepository.save(new Car("2", "BMW", 200));
        carRepository.save(new Car("3", "Audi", 20));
    }

    // GET ALL THE CARS
    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    // GET ONLY THE DESIRED CAR
    @Override
    public Car getCarbyPlateNumber(String plateNumber) throws Exception {
        return carRepository.findAll()
                .stream()
                .filter(car -> car.getPlateNumber().equals(plateNumber))
                .findFirst()
                .orElseThrow(()
                        -> new Exception("Car with plate number '" + plateNumber + "' not found.")
                );
    }

    // GET ALL THE AVAILABLE CARS
    @Override
    public List<Car> getAvailableCars() {
        return carRepository.findAll()
                .stream()
                .filter(car -> !car.isRented())
                .toList();
    }

    // RENT A CAR
    @Override
    public void rentCar(String plateNumber) throws Exception {
        Car car = getCarbyPlateNumber(plateNumber);
        if (car != null && !car.isRented()) {
            car.confirmRented();
            carRepository.save(car);
        } else {
            throw new Exception("Car not available for rent.");
        }
    }

    // RETURN A CAR
    @Override
    public void returnCar(String plateNumber) throws Exception {
        Car car = getCarbyPlateNumber(plateNumber);
        if (car != null && car.isRented()) {
            car.confirmReturned();
            carRepository.save(car);
        } else {
            throw new Exception("Car not available for return.");
        }
    }

}

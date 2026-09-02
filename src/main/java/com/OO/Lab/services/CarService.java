package com.OO.Lab.services;

import java.util.List;

import com.OO.Lab.bdd.Car;

public interface CarService {

    void addCar(Car car);

    List<Car> getAllCars();

    Car getCarbyPlateNumber(String plateNumber) throws Exception;

    List<Car> getAvailableCars();

    void rentCar(String plateNumber) throws Exception;

    void returnCar(String plateNumber) throws Exception;
}

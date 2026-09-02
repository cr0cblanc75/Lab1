package com.OO.Lab.bdd;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long CarId;

    private String plateNumber;
    private String brand;
    private Integer price;
    private boolean rented;

    protected Car() {

    }

    public Car(String plateNumber, String brand, int price) {
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.price = price;
        this.rented = false;
    }

    public void confirmRented() {
        this.rented = true;
    }

    public void confirmReturned() {
        this.rented = false;
    }

    public boolean isRented() {
        return this.rented;
    }

    public String getPlateNumber() {
        return this.plateNumber;
    }

    public String getBrand() {
        return this.brand;
    }

    public Integer getPrice() {
        return this.price;
    }

}

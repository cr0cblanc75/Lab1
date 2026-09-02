package com.OO.Lab.obj;

public class Car {

    private final String plateNumber;
    private final String brand;
    private final Integer price;
    private boolean rented;

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

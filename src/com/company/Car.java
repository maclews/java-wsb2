package com.company;

public class Car {
    final String manufacturer;
    final String model;
    Integer displacement;
    Integer enginePower;
    Double price;

    public Car(String manufacturer, String model, Integer displacement, Integer enginePower) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.displacement = displacement;
        this.enginePower = enginePower;
    }
}

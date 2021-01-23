package com.company.devices;

public class Car {
    final String manufacturer;
    final String model;
    Integer displacement;
    Integer enginePower;
    public Double price;

    public Car(String manufacturer, String model, Integer displacement, Integer enginePower, Double price) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.displacement = displacement;
        this.enginePower = enginePower;
    }

    @Override
    public String toString() {
        return "Car{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", displacement=" + displacement +
                ", enginePower=" + enginePower +
                ", price=" + price +
                '}';
    }
}

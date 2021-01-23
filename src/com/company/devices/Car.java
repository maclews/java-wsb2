package com.company.devices;

public class Car extends Device {
    final String manufacturer;
    final String model;
    Integer displacement;
    Integer enginePower;
    public Double price;

    public Car(String manufacturer, String model, Integer yearOfProduction, Integer displacement, Integer enginePower,
               Double price) {
        super(manufacturer, model, yearOfProduction);
        this.manufacturer = manufacturer;
        this.model = model;
        this.displacement = displacement;
        this.enginePower = enginePower;
    }

    public void turnOn() {
        System.out.println("Słychać piękne wycie trzycilindrowej osiemsetki. No bo nie ma na świecie nic lepszego niż" +
                " odpalana z samego rana Ticomotywa...");
    }

    @Override
    public String toString() {
        return "Car{" +
                "displacement=" + displacement +
                ", enginePower=" + enginePower +
                ", price=" + price +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                '}';
    }
}

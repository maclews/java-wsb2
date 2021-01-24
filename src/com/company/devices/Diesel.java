package com.company.devices;

public class Diesel extends Car{
    public Diesel(String manufacturer, String model, Integer yearOfProduction, Integer displacement, Integer enginePower, Double price) {
        super(manufacturer, model, yearOfProduction, displacement, enginePower, price);
    }

    public void refuel() {
        System.out.println("No to lejemy do pełna. Za 50 :)");
    }
}

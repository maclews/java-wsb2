package com.company.devices;

import com.company.Human;
import com.company.Sellable;

public abstract class Car extends Device implements Sellable {
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
        this.price = price;
    }

    public abstract void refuel();

    public void turnOn() {
        System.out.println("No mówiłem, że pali na dotyk...");
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        if (seller.getVehicle() != null) {
            if (buyer.getCash() >= price) {
                buyer.setCash(buyer.getCash() - price);
                seller.setCash(seller.getCash() + price);
                buyer.receiveVehicle(seller.getVehicle());
                seller.unsetVehicle();
                System.out.println("Pojazd został sprzedany nowemu właścicielowi.");
            } else {
                System.out.println("Za mało siana.");
            }
        } else {
            System.out.println("Lewizna. Sprzedający nie ma pojazdu.");
        }
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

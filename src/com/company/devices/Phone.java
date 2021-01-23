package com.company.devices;

public class Phone extends Device {
    public Phone(String manufacturer, String model, Integer yearOfProduction) {
        super(manufacturer, model, yearOfProduction);
    }

    public void turnOn() {
        System.out.println("Się włączyło. Chyba... bo zawibrowało. Ale dalej ciemno. (...) O! Teraz coś widać!");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

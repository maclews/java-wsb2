package com.company.devices;

public class Application implements Comparable<Application> {
    private String name;
    private String version;
    private Double price;

    public Application(String name, String version, Double price) {
        this.name = name;
        this.version = version;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Nazwa: " + name + ", wersja: " + version + ", cena: " + price;
    }

    @Override
    public int compareTo(Application o) {
        return this.getName().compareTo(o.getName());
    }
}

package com.company;

import com.company.creatures.Animal;
import com.company.devices.Car;
import com.company.devices.Phone;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;

public class Human {
    String firstName;
    String lastName;
    public Animal pet;
    private Car[] garage;
    private Integer garageSize;
    private Double salary;
    private LocalDateTime salaryLastAccessDateTime;
    private Double salaryLastAccessValue;
    Double cash;
    public Phone tel;

    private void sharedConstructor() {
        this.salary = 2600.0;
        this.salaryLastAccessDateTime = LocalDateTime.now();
        this.salaryLastAccessValue = this.salary;
        this.pet = null;
        this.prepGarage();
    }

    private void prepGarage() {
        this.garage = new Car[this.garageSize];
    }

    public Human() {
        this.garageSize = 4;
        this.sharedConstructor();
    }

    public Human(Integer garageSize) {
        this.garageSize = garageSize;
        this.sharedConstructor();
    }

    public Double getSalary() {
        System.out.println("Your salary info was last accessed on " + this.salaryLastAccessDateTime + ", it's value was " + salaryLastAccessValue);
        this.salaryLastAccessValue = this.salary;
        this.salaryLastAccessDateTime = LocalDateTime.now();
        return this.salary;
    }

    public void setSalary(Double salary) {
        if (salary < 0) {
            System.out.println("Salary cannot be a negative value.");
        } else {
            System.out.println("[PL] Poniższe pouczenia są przekazywane zgodnie z wewnętrzną instrukcją spółki Januszex. Proszę uważnie zapoznać się z tymi informacjami.");
            System.out.println("[PL] Nowe dane zostały wysłane do systemu księgowego.");
            System.out.println("[PL] Wymagany jest odbiór aneksu do umowy od pani Krysi z kadr.");
            System.out.println("[PL] ZUS i US zostały poinformowane o zmianie wypłaty - prosimy nie ukrywać dochodu.");
            this.salary = salary;
        }
    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public Car getVehicle(Integer space) {
        if (space >= 0 && space < this.garageSize) {
            return this.garage[space];
        } else {
            throw new IllegalArgumentException("Garage space number out of range");
        }
    }

    public void setVehicle(Integer space, Car newCar) {
        if (space >= 0 && space < this.garageSize) {
            if (this.salary > newCar.price) {
                this.garage[space] = newCar;
                System.out.println("New car bought in CASH");
            } else if (this.salary > (newCar.price / 12)) {
                this.garage[space] = newCar;
                System.out.println("New car bought with CREDIT");
            } else {
                System.out.println("Get yourself a better job or something first");
            }
        } else {
            throw new IllegalArgumentException("Garage space number out of range");
        }
    }

    public void receiveVehicle(Integer space, Car usedCar) {
        this.garage[space] = usedCar;
    }

    public void unsetVehicle(Integer space) {
        this.garage[space] = null;
    }

    public Double getGarageValue() {
        Double valueSum = 0.0;
        for (int i = 0; i < this.garageSize; i++) {
            if (this.garage[i] != null) valueSum += this.garage[i].price;
        }
        return valueSum;
    }

    public int returnFreeSpot() {
        int spot = -1;
        for (int i = 0; i < this.garageSize; i++) {
            if (this.garage[i] == null) {
                spot = i;
                break;
            }
        }
        return spot;
    }

    public void garageSort() {
        Arrays.sort(this.garage, (o1, o2) -> {
            Integer y1 = (o1 == null) ? Integer.MAX_VALUE : o1.yearOfProduction;
            Integer y2 = (o2 == null) ? Integer.MAX_VALUE : o2.yearOfProduction;
            return y1.compareTo(y2);
        });
    }

    public void listGarage() {
        for (Car vehicle : this.garage) {
            if (vehicle != null) System.out.println(vehicle);
        }
        System.out.println("--- END OF LIST ---");
    }

    @Override
    public String toString() {
        return "Human{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pet=" + pet +
        //        ", vehicle=" + foreach   +
                ", salary=" + salary +
                ", salaryLastAccessDateTime=" + salaryLastAccessDateTime +
                ", salaryLastAccessValue=" + salaryLastAccessValue +
                '}';
    }

}

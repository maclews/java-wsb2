package com.company;

import com.company.devices.Car;
import java.time.LocalDateTime;

public class Human {
    String firstName;
    String lastName;
    Animal pet;
    private Car vehicle;
    private Double salary;
    private LocalDateTime salaryLastAccessDateTime;
    private Double salaryLastAccessValue;

    public Human() {
        this.salary = 2600.0;
        this.salaryLastAccessDateTime = LocalDateTime.now();
        this.salaryLastAccessValue = this.salary;
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

    public Car getVehicle() {
        return vehicle;
    }

    public void setVehicle(Car newCar) {
        if (this.salary > newCar.price) {
            this.vehicle = newCar;
            System.out.println("New car bought in CASH");
        } else if (this.salary > (newCar.price / 12)) {
            this.vehicle = newCar;
            System.out.println("New car bought with CREDIT");
        } else {
            System.out.println("Get yourself a better job or something first");
        }
    }

    @Override
    public String toString() {
        return "Human{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pet=" + pet +
                ", vehicle=" + vehicle +
                ", salary=" + salary +
                ", salaryLastAccessDateTime=" + salaryLastAccessDateTime +
                ", salaryLastAccessValue=" + salaryLastAccessValue +
                '}';
    }
}

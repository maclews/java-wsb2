package com.company.devices;

import com.company.Human;
import com.company.SaleHistory;
import com.company.Sellable;

import java.util.ArrayList;
import java.util.List;

public abstract class Car extends Device implements Sellable{
    final String manufacturer;
    final String model;
    Integer displacement;
    Integer enginePower;
    public Double price;
    public List<Human> ownerList;
    public List<SaleHistory> saleHistoryList;

    public Car(String manufacturer, String model, Integer yearOfProduction, Integer displacement, Integer enginePower,
               Double price) {
        super(manufacturer, model, yearOfProduction);
        this.manufacturer = manufacturer;
        this.model = model;
        this.displacement = displacement;
        this.enginePower = enginePower;
        this.price = price;
        this.ownerList = new ArrayList<>();
        this.saleHistoryList = new ArrayList<>();
    }

    public abstract void refuel();

    public void turnOn() {
        System.out.println("No mówiłem, że pali na dotyk...");
    }

    public Human getLastOwner() {
        return this.ownerList.get(this.ownerList.size() - 1);
    }

    public boolean wasOwnedBy(Human id) {
        return this.ownerList.contains(id);
    }

    public boolean saleCheck(Human seller, Human buyer) {
        int x = -1;
        for (int i = this.ownerList.size() - 1; i >= 0; i--) {
            if (this.ownerList.get(i) == buyer) x = i;
        }
        if (x == -1) return false;
        return x > 0 && this.ownerList.get(x - 1) == seller;
    }

    public int saleCount() {
        return (this.ownerList.size() - 1);
    }

    public SaleHistory getLastSale() {
        return this.saleHistoryList.get(this.saleHistoryList.size() - 1);
    }

    @Override
    public void sell(Human seller, Human buyer, Double price, Integer sellSpot, Integer buySpot) {
        if (seller.getVehicle(sellSpot) != null) {
            if (seller.getVehicle(sellSpot).getLastOwner() == seller) {
                int buyerSpot = buyer.returnFreeSpot();
                if (buyerSpot < 0) throw new IndexOutOfBoundsException("Kupujący nie ma miejsca w garażu.");
                else if (buyer.getCash() >= price) {
                    buyer.setCash(buyer.getCash() - price);
                    seller.setCash(seller.getCash() + price);
                    buyer.receiveVehicle(buySpot, seller.getVehicle(sellSpot));
                    seller.unsetVehicle(sellSpot);
                    buyer.getVehicle(buyerSpot).ownerList.add(buyer);   // pozostawione w celu oceny :)
                    buyer.getVehicle(buyerSpot).saleHistoryList.add(new SaleHistory(buyer, seller, price));
                    System.out.println("Pojazd został sprzedany nowemu właścicielowi za " + price);
                } else {
                    throw new ArithmeticException("Za mało siana.");
                }
            } else {
                throw new SecurityException("Sprzedawca nie jest ostatnim właścicielem pojazdu.");
            }
        } else {
            throw new NullPointerException("Lewizna. Sprzedający nie ma pojazdu.");
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

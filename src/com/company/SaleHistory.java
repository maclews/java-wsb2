package com.company;

import java.time.LocalDateTime;

public class SaleHistory {
    private Human buyer;
    private Human seller;
    private Double price;
    private LocalDateTime saleTime;

    public SaleHistory(Human buyer, Human seller, Double price) {
        this.buyer = buyer;
        this.seller = seller;
        this.price = price;
        this.saleTime = LocalDateTime.now();
    }

    public Human getBuyer() {
        return this.buyer;
    }

    public Human getSeller() {
        return this.seller;
    }

    public Double getPrice() {
        return this.price;
    }

    public LocalDateTime getSaleTime() {
        return this.saleTime;
    }

    @Override
    public String toString() {
        return "Kupujący:\n" + this.buyer + "\n"
                + "Sprzedający:\n" + this.seller + "\n"
                + "Cena: " + this.price;
    }
}

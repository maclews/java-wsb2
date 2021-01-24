package com.company;

import com.company.creatures.Pet;
import com.company.devices.LPG;
import com.company.devices.Diesel;
import com.company.devices.Electric;
import com.company.devices.Phone;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Objects;

public class Main {

    public static void main(String[] args) throws MalformedURLException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

        Human me = new Human();

        me.firstName = "Maciej";
        me.lastName = "Lewandowski";
        me.pet = new Pet("dog");

        me.pet.feed();
        me.pet.takeForAWalk();
        me.pet.feed();
        me.pet.takeForAWalk();
        me.pet.feed();
        me.pet.takeForAWalk();
        me.pet.feed();
        me.pet.feed();
        me.pet.feed();
        me.pet.takeForAWalk();
        me.pet.takeForAWalk();
        me.pet.takeForAWalk();
        me.pet.takeForAWalk();
        me.pet.takeForAWalk();
        me.pet.takeForAWalk();
        me.pet.takeForAWalk();
        me.pet.takeForAWalk();
        me.pet.feed();
        me.pet.feed();
        me.pet.takeForAWalk();
        me.pet.takeForAWalk();
        me.pet.takeForAWalk();
        me.pet.takeForAWalk();
        me.pet.takeForAWalk();
        me.pet.takeForAWalk();
        me.pet.takeForAWalk();
        me.pet.feed();
        me.pet.takeForAWalk();

        LPG ticomotywa = new LPG("Daewoo", "Tico", 1999, 796, 41, 4206.9);
        me.setVehicle(0, ticomotywa);

        LPG ticomotywa2 = new LPG("Daewoo", "Tico", 1999, 796, 41, 4206.9);

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println(Objects.equals(ticomotywa, ticomotywa2));
        System.out.println(ticomotywa);
        System.out.println(ticomotywa2);
        System.out.println(me.pet);

        Phone brick = new Phone("Szajsung", "Galaksy Be-pińć", 2012);

        ticomotywa.turnOn();
        brick.turnOn();

        System.out.println(ticomotywa.toString());
        System.out.println(brick.toString());

        Human notMe = new Human();

        me.cash = 10000.0;
        notMe.cash = 20000.0;

        me.pet.sell(me, notMe, 500.0, null, null);
        System.out.println(me.cash + " -- " + notMe.cash);

        me.getVehicle(0).sell(me, notMe, 2000.0, 0, 0);
        System.out.println(me.cash + " -- " + notMe.cash);

        me.tel = brick;
        me.tel.sell(me, notMe, 1500.0, null, null);
        System.out.println(me.cash + " -- " + notMe.cash);

        Electric tesla = new Electric("Tesla", "Model S", 2018, 0, 613, 50000.0);
        Diesel passat = new Diesel("Król wsi", "w TDI", 1998, 1900, 90, 500.0);

        notMe.getVehicle(0).refuel();
        me.receiveVehicle(1,tesla);
        me.getVehicle(1).refuel();
        me.receiveVehicle(2, passat);
        me.getVehicle(2).refuel();

        brick.installApp("Dialer");
        brick.installApp("Flashlight", "2.0");
        brick.installApp("SmokeDetector", "4.20", "apphub.com");
        brick.installApp("Calculator", "Camera", "WebBrowser");
        brick.installApp(new URL("https://play.google.com/store/apps/details?id=com.android.chrome"));
        brick.installApp("Flashlight", "2.0");
        brick.installApp("Flashlight", "2.1");

        System.out.println("GARAGE TOTAL VALUE: " + me.getGarageValue());

        me.garageSort();

        me.listGarage();
        notMe.listGarage();

        System.out.println(notMe.getVehicle(0).saleCheck(notMe, me));
        System.out.println(notMe.getVehicle(0).getLastOwner());
        System.out.println(notMe.getVehicle(0).wasOwnedBy(me));
        System.out.println(notMe.getVehicle(0).saleCheck(me, notMe));
        System.out.println("Transakcji kupna/sprzedaży: " + notMe.getVehicle(0).saleCount());
        System.out.println(notMe.getVehicle(0).getLastSale());
    }
}

package com.company.devices;

import com.company.Human;
import com.company.Sellable;

import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Phone extends Device implements Sellable {
    static final String DEFAULT_APP_SERVER_NAME = "www.example.com";
    static final String DEFAULT_APP_SERVER_PROTOCOL = "https";
    static final String DEFAULT_APP_VERSION = "1.0";
    List<String> appList;

    private Integer findAppOnList(String appName) {
        Collections.sort(this.appList);
        return Collections.binarySearch(this.appList, appName);
    }

    private void putOnAppList(String appName) {
        if (this.findAppOnList(appName) < 0) {
            this.appList.add(appName);
            System.out.println("[  OK  ] App from " + appName + " successfully installed.");
        } else {
            System.out.println("[ FAIL ] App from " + appName + " already installed.");
        }
    }

    public Phone(String manufacturer, String model, Integer yearOfProduction) {
        super(manufacturer, model, yearOfProduction);
        this.appList = new ArrayList<>();
    }

    public void turnOn() {
        System.out.println("Się włączyło. Chyba... bo zawibrowało. Ale dalej ciemno. (...) O! Teraz coś widać!");
    }

    public void sell(Human seller, Human buyer, Double price, Integer sellSpot, Integer buySpot) {
        if (buyer.getCash() >= price) {
            buyer.setCash(buyer.getCash() - price);
            seller.setCash(seller.getCash() + price);
            buyer.tel = seller.tel;
            seller.tel = null;
            System.out.println("Telefon został sprzedany nowemu właścicielowi.");
        } else {
            System.out.println("Za mało siana.");
        }
    }

    public void installApp(String appName) {
        this.putOnAppList(
                DEFAULT_APP_SERVER_PROTOCOL
                        + "://" + DEFAULT_APP_SERVER_NAME
                        + "/" + appName
                        + "?v=" + DEFAULT_APP_VERSION
        );
    }
    public void installApp(String appName, String appVersion) {
        this.putOnAppList(
                DEFAULT_APP_SERVER_PROTOCOL
                        + "://" + DEFAULT_APP_SERVER_NAME
                        + "/" + appName
                        + "?v=" + appVersion
        );
    }
    public void installApp(String appName, String appVersion, String serverAddr) {
        this.putOnAppList(
                DEFAULT_APP_SERVER_PROTOCOL
                        + "://" + serverAddr
                        + "/" + appName
                        + "?v=" + appVersion
        );
    }
    public void installApp(String[] appNameList) {
        for (String appName : appNameList) {
            this.putOnAppList(
                    DEFAULT_APP_SERVER_PROTOCOL
                            + "://" + DEFAULT_APP_SERVER_NAME
                            + "/" + appName
                            + "?v=" + DEFAULT_APP_VERSION
            );

        }
    }
    public void installApp(URL urlToApp) {
        this.putOnAppList(
                urlToApp.getProtocol()
                        + "://" + urlToApp.getHost()
                        + urlToApp.getPath()
                        + "?" + urlToApp.getQuery()
        );

    }


    @Override
    public String toString() {
        return super.toString();
    }
}

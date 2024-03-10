package com.proj.java;

import java.util.*;

public abstract class Passenger {
    protected String name;
    protected int passengerNumber;

    protected int balance;
    public Passenger(String name, int passengerNumber, int balance) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.balance = balance;
    }

    public Passenger(String name, int passengerNumber) {
        this.name = name;
        this.passengerNumber = passengerNumber;
    }

    public String getName() {
        return this.name;
    }

    public int getPassengerNumber() {
        return passengerNumber;
    }

    public int getBalance() {
        return balance;
    }

    public abstract double getDiscount();
    public abstract PassengerType getType();

    public abstract List<Activity> getActivities();

    public boolean addActivity(Activity activity) {

        return false;
    }

}


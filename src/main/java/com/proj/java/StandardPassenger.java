package com.proj.java;

import java.util.ArrayList;
import java.util.List;

public class StandardPassenger extends Passenger {

    private final List<Activity> activities;

    public StandardPassenger(String name, int passengerNumber, int balance) {
        super(name, passengerNumber, balance);
        this.activities = new ArrayList<>();
        this.balance = balance;
    }

    @Override
    public double getDiscount() {
        return 0;
    }

    @Override
    public PassengerType getType() {
        return PassengerType.STANDARD;
    }

    @Override
    public List<Activity> getActivities() {
        return activities;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean addActivity(Activity activity) {
        if (activity.getAvailableSpots() <= 0) {
            throw new IllegalStateException("Activity capacity exceeded.");
        }

        double discount = getDiscount();
        double price = activity.getCost() - (activity.getCost() * discount);

        if (price > balance) {
            throw new IllegalStateException("Insufficient balance to sign up for activity.");
        }

        activities.add(activity);
        activity.setCapacity(activity.getCapacity() - 1);
        balance -= (int) price;
        return true;
    }
}

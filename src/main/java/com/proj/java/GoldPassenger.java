package com.proj.java;


import java.util.ArrayList;
import java.util.List;

public class GoldPassenger extends Passenger {
    private final List<Activity> activities;

    public GoldPassenger(String name, int passengerNumber, int balance) {
        super(name, passengerNumber);
        this.activities = new ArrayList<>();
        this.balance= balance;
    }

    @Override
    public double getDiscount() {
        return 0.1;
    }

    @Override
    public PassengerType getType() {
        return PassengerType.GOLD;
    }

    @Override
    public List<Activity> getActivities() {
        return activities;
    }

    public boolean addActivity(Activity activity) {
        if (activity.getCapacity() <= 0) {
            throw new IllegalStateException("Activity capacity exceeded.");
        }

        double discount = getDiscount();
        int price = (int) (activity.getCost() - (activity.getCost() * discount));


        if (price > balance) {
            throw new IllegalStateException("Insufficient balance to sign up for activity.");
        }

        activities.add(activity);
        activity.setCapacity((int) (activity.getCapacity() - 1));
        balance -= price;
        return true;
    }


    public void setBalance(int balance) {
        this.balance = balance;
    }
}


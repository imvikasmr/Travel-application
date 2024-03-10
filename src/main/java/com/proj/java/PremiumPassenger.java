package com.proj.java;

import java.util.ArrayList;
import java.util.List;

public class PremiumPassenger extends Passenger {
    private final List<Activity> activities;
    private int balance;

    public PremiumPassenger(String name, int passengerNumber) {
        super(name, passengerNumber);
        this.activities = new ArrayList<>();
        this.balance = 100;
    }

    @Override
    public double getDiscount() {
        return 1;
    }

    @Override
    public PassengerType getType() {
        return PassengerType.PREMIUM;
    }

    @Override
    public List<Activity> getActivities() {
        return activities;
    }

    public boolean addActivity(Activity activity) {
        if (activity.getCapacity() <= 0) {
            throw new IllegalStateException("Activity capacity exceeded.");
        }

        activities.add(activity);
        activity.setCapacity((int) (activity.getCapacity() - 1));
        return true; // Return true if the activity is successfully added
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }
}

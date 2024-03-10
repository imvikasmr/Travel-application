package com.proj.java;

import java.util.ArrayList;
import java.util.List;


public class Activity {
    private String name;
    private double cost;
    private int capacity;
    private String description;
    private final Destination destination;
    private final List<Passenger> passengers;
    private boolean cancelled;
    private boolean active;
    private boolean archived;
    private boolean upcoming;
    private boolean past;

    public Activity(String name, double cost, int capacity, String description, Destination destination, boolean cancelled, boolean active, boolean archived, boolean upcoming, boolean past) {
        this.name = name;
        this.cost = cost;
        this.capacity = capacity;
        this.description = description;
        this.destination = destination;
        this.passengers = new ArrayList<Passenger>();
        this.cancelled = cancelled;
        this.active = active;
        this.archived = archived;
        this.upcoming = upcoming;
        this.past = past;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getDescription() {
        return description;
    }

    public Destination getDestination() {
        return destination;
    }

    public boolean isFull() {
        return this.passengers.size() == this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean signUp(Passenger passenger) {
        if (capacity > 0 && !isSignedUp(passenger) && isActive()) {
            capacity -= 1;
            passenger.addActivity(this);
            passengers.add(passenger);
            return true;
        }
        return false;
    }

    public boolean isSignedUp(Passenger passenger) {
        return this.passengers.contains(passenger);
    }

    public boolean removePassenger(Passenger passenger) {
        return this.passengers.remove(passenger);
    }

    public int getAvailableSpots() {
        return this.capacity - this.passengers.size();
    }

    public int getNumberOfPassengers() {
        return this.passengers.size();
    }

    public double getPercentageUsed() {
        return (double) this.passengers.size() / this.capacity * 100;
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public void cancel() {
        this.active = false;
        this.cancelled = true;
    }

    public boolean isActive() {
        return this.active;
    }

    public boolean isArchived() {
        return this.archived;
    }

    public void archive() {
        this.archived = true;
    }

    public boolean isUpcoming() {
        return this.upcoming;
    }

    public void setAsPast() {
        this.upcoming = false;
        this.past = true;
    }

    public boolean isPast() {
        return this.past;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setCost(double cost) {
        this.cost = cost;;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
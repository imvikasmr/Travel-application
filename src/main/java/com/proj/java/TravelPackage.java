package com.proj.java;

import java.util.*;

public class TravelPackage {
    private final String name;
//    private final int passengerCapacity;
    private final int capacity;
    private final List<Destination> itinerary;
    private List<Passenger> passengers;
    private final List<Destination> destinations;

    public TravelPackage(String name,  int capacity) {
        this.name = name;
//        this.passengerCapacity = passengerCapacity;
        this.capacity = capacity;
        this.itinerary = new ArrayList<>();
        this.passengers = new ArrayList<>();
        this.destinations = new ArrayList<>();
    }

    public TravelPackage(String name, int capacity, List<Destination> destinations) {
        this.name = name;
        this.capacity = capacity;
        this.itinerary = new ArrayList<>();
        this.passengers = new ArrayList<>();
        this.destinations = destinations;
    }

    public String getName() {
        return name;
    }

    public void addDestination(Destination destination) {
        destinations.add(destination);
    }

    public List<Destination> getDestinations() {
        return Collections.unmodifiableList(destinations);
    }

    public boolean addPassenger(Passenger passenger) {
        if (passengers.size() < capacity) {
            passengers.add(passenger);
        } else {
            System.out.println("No more space for passengers.");
        }
        return false;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public List<Passenger> getPassengers() {
        return Collections.unmodifiableList(passengers);
    }

    public String printItinerary() {
        StringBuilder itinerary = new StringBuilder();
        itinerary.append("Travel Package: ").append(name).append("\nPassenger Capacity: ").append(capacity).append("\nDestinations:\n");
        for (Destination destination : destinations) {
            itinerary.append(destination.getName()).append("\nActivities:\n");
            for (Activity activity : destination.getActivities()) {
                itinerary.append(activity.getName()).append(" - Cost: ").append(activity.getCost()).append(" - Capacity: ").append(activity.getCapacity()).append("\n");
            }
        }
        return itinerary.toString();
    }

    public List<Activity> getAvailableActivities() {
        List<Activity> availableActivities = new ArrayList<>();
        for (Destination destination : destinations) {
            for (Activity activity : destination.getActivities()) {
                if (activity.getCapacity() > activity.getPassengers().size()) {
                    availableActivities.add(activity);
                }
            }
        }
        return availableActivities;
    }

    public void printPassengerList() {
        System.out.println("Travel Package: " + name);
        System.out.println("Passenger Capacity: " + capacity);
        System.out.println("Number of Passengers: " + passengers.size());
        int passengerNumber = 1;
        for (Passenger passenger : passengers) {
            System.out.println(passenger.getName() + " - Passenger Number: " + passengerNumber);
            passengerNumber++;
        }
    }



    public void printPassengerDetails(Passenger passenger) {
        System.out.println("Name: " + passenger.getName());
        System.out.println("Passenger Number: " + passenger.getPassengerNumber());
        if (passenger instanceof StandardPassenger) {
            System.out.println("Balance: " + ((StandardPassenger) passenger).getBalance());
        }
        System.out.println("Activities:");
        for (Activity activity : passenger.getActivities()) {
            System.out.println("- " + activity.getName() + " - Destination: " + activity.getDestination().getName() + " - Cost: " + activity.getCost() + " - Capacity: " + activity.getCapacity() + " - Passengers: " + activity.getPassengers().size());
        }
    }

    public void printAvailableActivities() {
        for (Destination destination : itinerary) {
            System.out.println("Destination: " + destination.getName());
            List<Activity> activities = destination.getActivities();
            for (Activity activity : activities) {
                if (activity.getCapacity() > activity.getPassengers().size()) {
                    System.out.println("- " + activity.getName() + " - Description: " + activity.getDescription() +
                            " - Cost: " + activity.getCost() + " - Spaces available: " + (activity.getCapacity() - activity.getPassengers().size()));
                }
            }
        }
    }

    public String getPassengerDetails(Passenger passenger) {
        StringBuilder passengerDetails = new StringBuilder();
        passengerDetails.append("Name: ").append(passenger.getName()).append("\nPassenger Number: ").append(passenger.getPassengerNumber()).append("\n");
        if (passenger instanceof StandardPassenger) {
            StandardPassenger standardPassenger = (StandardPassenger) passenger;
            passengerDetails.append("Balance: ").append(standardPassenger.getBalance()).append("\n");
        }
        passengerDetails.append("Activities: ");
        for (Activity activity : passenger.getActivities()) {
            passengerDetails.append(activity.getName()).append(" - Destination: ").append(activity.getDestination().getName()).append(" - Cost: ").append(activity.getCost()).append(" - Capacity: ").append(activity.getCapacity()).append(" - Passengers: ").append(activity.getPassengers().size()).append("\n");
        }
        return passengerDetails.toString();
    }

    public String getItinerary() {
        StringBuilder itinerary = new StringBuilder();
        itinerary.append("Travel Package: ").append(name).append("\nPassenger Capacity: ").append(capacity).append("\nDestinations:\n");
        for (Destination destination : destinations) {
            itinerary.append(destination.getName()).append("\nActivities:\n");
            for (Activity activity : destination.getActivities()) {
                itinerary.append(activity.getName()).append(" - Cost: ").append(activity.getCost()).append(" - Capacity: ").append(activity.getCapacity()).append("\n");
            }
        }
        return itinerary.toString();
    }

    public String getPassengerList() {
        StringBuilder passengerList = new StringBuilder();
        passengerList.append("Travel Package: ").append(name).append("\nPassenger Capacity: ").append(capacity).append("\nNumber of Passengers: ").append(passengers.size()).append("\n");
        int passengerNumber = 1;
        for (Passenger passenger : passengers) {
            passengerList.append(passenger.getName()).append(" - Passenger Number: ").append(passengerNumber).append("\n");
            passengerNumber++;
        }
        return passengerList.toString();
    }

}
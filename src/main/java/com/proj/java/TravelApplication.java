package com.proj.java;

import java.util.List;

public class TravelApplication {

    public static void main(String[] args) {

        // Create destinations
        Destination paris = new Destination("Paris");
        Destination rome = new Destination("Rome");

        // Create activities
        Activity eiffelTower = new Activity("Eiffel Tower", 50.0, 20, "Visit the Eiffel Tower", paris, false, true, false, true, false);
        Activity louvre = new Activity("Louvre Museum",100, 30, "Visit the Louvre Museum", paris, false, true, false, true, false);
        Activity colosseum = new Activity("Colosseum", 75, 15, "Tour the ancient Colosseum", rome, false, true, false, true, false);
        Activity vatican = new Activity("Vatican Museums", 80, 25, "Visit the Vatican Museums and Sistine Chapel", rome, false, true, false, true, false);

        // Create travel package
        TravelPackage trip = new TravelPackage("European Vacation", 10);

        // Add activities to destinations
        trip.addDestination(paris);
        paris.addActivity(louvre);
        trip.addDestination(rome);
        rome.addActivity(colosseum);
        rome.addActivity(vatican);

        // Create passengers
        StandardPassenger alice = new StandardPassenger("Alice", 1, 1000);
        GoldPassenger bob = new GoldPassenger("Bob", 2, 1000);
        PremiumPassenger charlie = new PremiumPassenger("Charlie", 3);

        // Add passengers to travel package
        trip.addPassenger(alice);
        trip.addPassenger(bob);
        trip.addPassenger(charlie);

        // Alice signs up for activities
        alice.addActivity(eiffelTower);
        alice.addActivity(louvre);
        try {
            alice.addActivity(colosseum); // fails because capacity exceeded
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        // Bob signs up for activities with 10% discount
        bob.addActivity(eiffelTower);
        bob.addActivity(louvre);

        // Charlie signs up for activities for free
        charlie.addActivity(louvre);
        charlie.addActivity(colosseum);

        // Print travel package itinerary
        trip.printItinerary();

        // Print passenger list
        trip.printPassengerList();

        // Print individual passenger details
        System.out.println("\nPassenger Details:");
        System.out.println(alice.getName() + " #" + alice.getPassengerNumber());
        System.out.println("Balance: " + alice.getBalance());
        System.out.println("Activities:");
        for (Activity activity : alice.getActivities()) {
            System.out.println("- " + activity.getName() + " at " + activity.getDestination().getName());
        }

        System.out.println("\n" + bob.getName() + " #" + bob.getPassengerNumber());
        System.out.println("Balance: " + bob.getBalance());
        System.out.println("Activities:");
        for (Activity activity : bob.getActivities()) {
            System.out.println("- " + activity.getName() + " at " + activity.getDestination().getName());
        }

        System.out.println("\n" + charlie.getName() + " #" + charlie.getPassengerNumber());
        System.out.println("Activities:");
        for (Activity activity : charlie.getActivities()) {
            System.out.println("- " + activity.getName() + " at " + activity.getDestination().getName());
        }


        // Print activities with available spaces and their remaining capacity
        System.out.println("\nActivities with available spaces and their remaining capacity:");
        List<Destination> destinations = trip.getDestinations();
        for (Destination destination : destinations) {
            System.out.println("- " + destination.getName());
            List<Activity> activities = destination.getActivities();
            System.out.println("Activities:");
            for (Activity activity : activities) {
                int remainingCapacity = activity.getCapacity() - activity.getPassengers().size();
                if (remainingCapacity > 0) {
                    System.out.println("-- " + activity.getName() + " (" + remainingCapacity + " spaces available)");
                }
            }
        }
    }
}

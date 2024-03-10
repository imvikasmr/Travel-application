import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.proj.java.Destination;
import com.proj.java.Passenger;
import com.proj.java.StandardPassenger;
import com.proj.java.TravelPackage;

class TravelPackageTests {
    private TravelPackage trip;

    @BeforeEach
    public void setup() {
        Destination travelDestination1 = new Destination("Paris");
        Destination travelDestination2 = new Destination("Rome");
        List<Destination> destinations = new ArrayList<>();
        destinations.add(travelDestination1);
        destinations.add(travelDestination2);
        trip = new TravelPackage("European Vacation", 10, destinations);
    }

    @Test
    public void testGetName() {
        assertEquals("European Vacation", trip.getName());
    }

    @Test
    public void testGetCapacity() {
        assertEquals(10, trip.getCapacity());
    }

    @Test
    public void testGetDestinations() {
        List<Destination> expectedDestinations = new ArrayList<>();
        expectedDestinations.add(new Destination("Paris"));
        expectedDestinations.add(new Destination("Rome"));
        assertEquals(expectedDestinations, trip.getDestinations());
    }

    @Test
    public void testAddDestination() {
        Destination newDestination = new Destination("London");
        trip.addDestination(newDestination);
        List<Destination> expectedDestinations = new ArrayList<>();
        expectedDestinations.add(new Destination("Paris"));
        expectedDestinations.add(new Destination("Rome"));
        expectedDestinations.add(newDestination);
        assertEquals(expectedDestinations, trip.getDestinations());
    }

    @Test
    public void testAddPassenger() {
        Passenger alice = new StandardPassenger("Alice", 1, 100);
        Passenger bob = new StandardPassenger("Bob", 2, 100);
        trip.addPassenger(alice);
        trip.addPassenger(bob);
        List<Passenger> expectedPassengers = new ArrayList<>();
        expectedPassengers.add(alice);
        expectedPassengers.add(bob);
        assertEquals(expectedPassengers, trip.getPassengers());
    }

    @Test
    public void testGetPassengers() {
        Passenger alice = new StandardPassenger("Alice", 1, 100);
        Passenger bob = new StandardPassenger("Bob", 2, 100);
        trip.addPassenger(alice);
        trip.addPassenger(bob);
        List<Passenger> expectedPassengers = new ArrayList<>();
        expectedPassengers.add(alice);
        expectedPassengers.add(bob);
        assertEquals(expectedPassengers, trip.getPassengers());
    }


    @Test
    public void testAddPassengerWhenCapacityIsReached() {
        Passenger alice = new StandardPassenger("Alice", 1, 100);
        Passenger bob = new StandardPassenger("Bob", 2, 150);
        Passenger charlie = new StandardPassenger("Charlie", 3, 200);
        Passenger david = new StandardPassenger("David", 4, 250);

        trip.addPassenger(alice);
        trip.addPassenger(bob);
        trip.addPassenger(charlie);

        assertFalse(trip.addPassenger(david));
        assertEquals(4, trip.getPassengers().size());
    }

    @Test
    public void testAddPassengerWhenCapacityIsZero() {
        Passenger alice = new StandardPassenger("Alice", 1, 100);

        TravelPackage trip = new TravelPackage("European Vacation", 0);

        assertFalse(trip.addPassenger(alice));
        assertEquals(0, trip.getPassengers().size());
    }

    @Test
    public void testSetPassengers() {
        Passenger alice = new StandardPassenger("Alice", 1, 100);
        Passenger bob = new StandardPassenger("Bob", 2, 150);
        Passenger charlie = new StandardPassenger("Charlie", 3, 200);

        List<Passenger> newPassengers = new ArrayList<>();
        newPassengers.add(charlie);
        newPassengers.add(bob);
        newPassengers.add(alice);

        trip.setPassengers(newPassengers);

        List<Passenger> actualPassengers = trip.getPassengers();

        assertEquals(3, actualPassengers.size());
        assertEquals("Charlie", actualPassengers.get(0).getName());
        assertEquals("Bob", actualPassengers.get(1).getName());
        assertEquals("Alice", actualPassengers.get(2).getName());
    }

}
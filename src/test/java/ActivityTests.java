import static org.junit.jupiter.api.Assertions.*;

import com.proj.java.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ActivityTests {
    private Activity activity;

    public void setUp() {
        setUpActivity();
    }
    private void setUpActivity() {
        String name = "Default Activity";
        double cost = 50.0;
        int capacity = 20;
        String description = "Visit the Eiffel Tower";
        Destination destination = new Destination("Paris");
        boolean cancelled = false;
        boolean active = true;
        boolean archived = false;
        boolean upcoming = true;
        boolean past = false;
    
        activity = new Activity(name, cost, capacity, description, destination, cancelled, active, archived, upcoming, past);
    }

    @Test
    public void testGetName() {
        setUp();
        activity.setName("Eiffel Tower");
        assertEquals("Eiffel Tower", activity.getName());
    }

    @Test
    public void testGetCost() {
        setUp();
        activity.setCost(50);
        assertEquals(50.0, activity.getCost());
    }

    @Test
    public void testGetCapacity() {
        setUp();
        activity.setCapacity(20);
        assertEquals(20.0, activity.getCapacity());
    }

    @Test
    public void testGetDescription() {
        setUp();
        activity.setDescription("Visit the Eiffel Tower");
        assertEquals("Visit the Eiffel Tower", activity.getDescription());
    }

    @Test
    public void testGetDestination() {
        setUp();
        Destination expectedDestination = new Destination("Paris");
        assertEquals(expectedDestination, activity.getDestination());
    }

    @Test
    public void testSetCapacity() {
        setUp();
        activity.setCapacity(15);
        assertEquals(15.0, activity.getCapacity());
    }


    @Test
    public void testSignUpNoSpaces() {
        setUp();
        Passenger passenger = new StandardPassenger("Alice", 1, 10000);
        for (int i = 0; i < 20; i++) {
            activity.signUp(passenger);
        }
        assertFalse(activity.signUp(passenger));
        assertTrue(activity.getPassengers().contains(passenger));
    }

    @Test
    public void testSignUpWithAvailableCapacity() {
        // Arrange
        Destination testDestination = new Destination("Test Destination");
        Activity activity = new Activity("Test Activity", 10.0, 2, "Test Description", testDestination, false, true, false, true, false);
        Passenger passenger = new StandardPassenger("Alice", 1, 10000);

        // Act
        boolean result = activity.signUp(passenger);

        // Assert
        assertTrue(result);
        assertEquals(1, activity.getPassengers().size());
        assertTrue(activity.getPassengers().contains(passenger));
    }

    @Test
    public void testSignUpWithFullCapacity() {
        // Arrange
        Destination testDestination = new Destination("Test Destination");
        Activity activity = new Activity("Test Activity", 10.0, 0, "Test Description", testDestination, false, true, false, true, false);
        Passenger passenger = new StandardPassenger("Bob", 2, 100);

        // Act
        boolean result = activity.signUp(passenger);

        // Assert
        assertFalse(result);
        assertEquals(0, activity.getCapacity());
        assertEquals(0, activity.getPassengers().size());
    }


    @Test
    public void testGetPassengers() {
        setUp();
        Passenger passenger1 = new StandardPassenger("Alice", 1, 100);
        Passenger passenger2 = new StandardPassenger("Bob", 2, 100);
        activity.signUp(passenger1);
        activity.signUp(passenger2);
        List<Passenger> expectedPassengers = new ArrayList<>();
        expectedPassengers.add(passenger1);
        expectedPassengers.add(passenger2);
        assertIterableEquals(expectedPassengers, activity.getPassengers());
    }
}
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.proj.java.Activity;
import com.proj.java.Destination;
import com.proj.java.PassengerType;
import com.proj.java.StandardPassenger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StandardPassengerTests {
    private StandardPassenger standardPassenger;
    private Activity eiffelTower;

    @BeforeEach
    public void setUp() {
        Destination paris = new Destination("Paris");
        eiffelTower = new Activity("Eiffel Tower", 10.0, 2, "Test Description", paris, false, true, false, true, false);
        standardPassenger = new StandardPassenger("Alice", 1, 100);
    }

    @Test
    public void testGetDiscount() {
        assertEquals(0.0, standardPassenger.getDiscount());
    }

    @Test
    public void testGetType() {
        assertEquals(PassengerType.STANDARD, standardPassenger.getType());
    }

    @Test
    public void testAddActivityWithAvailableCapacity() {
        assertTrue(standardPassenger.addActivity(eiffelTower));
        assertEquals(1, standardPassenger.getActivities().size());
        assertEquals(eiffelTower, standardPassenger.getActivities().get(0));
        assertEquals(10.0, eiffelTower.getCost());
        assertEquals(1, eiffelTower.getCapacity());
        assertEquals(90, standardPassenger.getBalance());
    }

    @Test
    public void testAddActivityWithFullCapacity() {
        Activity louvreMuseum = new Activity("Louvre Museum", 10.0, 0, "Test Description", new Destination("Paris"), false, true, false, true, false);
        assertThrows(IllegalStateException.class, () -> standardPassenger.addActivity(louvreMuseum));
        assertEquals(0, standardPassenger.getActivities().size());
        assertEquals(100, standardPassenger.getBalance());
    }

    @Test
    public void testAddActivityWithInsufficientBalance() {
        Activity louvreMuseum = new Activity("Louvre Museum", 200.0, 2, "Test Description", new Destination("Paris"), false, true, false, true, false);
        assertThrows(IllegalStateException.class, () -> standardPassenger.addActivity(louvreMuseum));
        assertEquals(0, standardPassenger.getActivities().size());
        assertEquals(100, standardPassenger.getBalance());
    }

    @Test
    public void testSetBalance() {
        standardPassenger.setBalance(50);
        assertEquals(50, standardPassenger.getBalance());
    }
}

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


import com.proj.java.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GoldPassengerTests {
    private GoldPassenger goldPassenger;
    private Activity eiffelTower;
    private Destination paris;

    @BeforeEach
    public void setUp() {
        Destination paris = new Destination("Paris");
        eiffelTower = new Activity("Eiffel Tower", 10.0, 2, "Test Description", paris, false, true, false, true, false);
        goldPassenger = new GoldPassenger("Alice", 1, 100);
    }

    @Test
    public void testGetDiscount() {
        assertEquals(0.1, goldPassenger.getDiscount());
    }

    @Test
    public void testGetType() {
        assertEquals(PassengerType.GOLD, goldPassenger.getType());
    }

    @Test
    public void testAddActivityWithAvailableCapacity() {
        assertTrue(goldPassenger.addActivity(eiffelTower));
        assertEquals(1, goldPassenger.getActivities().size());
        assertEquals(eiffelTower, goldPassenger.getActivities().get(0));
        double originalCost = eiffelTower.getCost();
        double discountedCost = originalCost * (1 - goldPassenger.getDiscount());
        assertEquals(1, eiffelTower.getCapacity());
    }

    @Test
    public void testAddActivityWithFullCapacity() {
        Activity louvreMuseum = new Activity("Louvre Museum", 10.0, 0, "Test Description", paris, false, true, false, true, false);
        assertThrows(IllegalStateException.class, () -> goldPassenger.addActivity(louvreMuseum));
        assertEquals(0, goldPassenger.getActivities().size());
        assertEquals(100, goldPassenger.getBalance());
    }

    @Test
    public void testAddActivityWithInsufficientBalance() {
        Activity louvreMuseum = new Activity("Louvre Museum", 200.0, 1, "Test Description", paris, false, true, false, true, false);
        assertThrows(IllegalStateException.class, () -> goldPassenger.addActivity(louvreMuseum));
        assertEquals(0, goldPassenger.getActivities().size());
        assertEquals(100, goldPassenger.getBalance());
    }

    @Test
    public void testSetBalance() {
        goldPassenger.setBalance(50);
        assertEquals(50, goldPassenger.getBalance());
    }
}
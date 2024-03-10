import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


import com.proj.java.Activity;
import com.proj.java.Destination;
import com.proj.java.PassengerType;
import com.proj.java.PremiumPassenger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PremiumPassengerTests {
    private PremiumPassenger premiumPassenger;
    private Activity eiffelTower;
    private Destination paris;

    @BeforeEach
    public void setUp() {
        Destination paris = new Destination("Paris");
        eiffelTower = new Activity("Eiffel Tower", 10.0, 2, "Test Description", paris, false, true, false, true, false);
        premiumPassenger = new PremiumPassenger("Bob", 2);
    }

    @Test
    public void testGetDiscount() {
        assertEquals(1.0, premiumPassenger.getDiscount());
    }

    @Test
    public void testGetType() {
        assertEquals(PassengerType.PREMIUM, premiumPassenger.getType());
    }

    @Test
    public void testAddActivityWithAvailableCapacity() {
        assertTrue(premiumPassenger.addActivity(eiffelTower));
        assertEquals(1, premiumPassenger.getActivities().size());
        assertEquals(eiffelTower, premiumPassenger.getActivities().get(0));
        assertEquals(1, eiffelTower.getCapacity());
        assertEquals(100, premiumPassenger.getBalance());
    }

    @Test
    public void testAddActivityWithFullCapacity() {
        Activity louvreMuseum = new Activity("Louvre Museum", 10.0, 0, "Test Description", paris, false, true, false, true, false);
        assertThrows(IllegalStateException.class, () -> premiumPassenger.addActivity(louvreMuseum));
        assertEquals(0, premiumPassenger.getActivities().size());
        assertEquals(100, premiumPassenger.getBalance());
    }

    @Test
    public void testAddActivityWithDiscountedCost() {
        Activity louvreMuseum = new Activity("Louvre Museum", 10.0, 2, "Test Description", paris, false, true, false, true, false);
        premiumPassenger.setBalance(15);
        assertTrue(premiumPassenger.addActivity(louvreMuseum));
        assertEquals(1, premiumPassenger.getActivities().size());
        assertEquals(louvreMuseum, premiumPassenger.getActivities().get(0));
        assertEquals(10.0, louvreMuseum.getCost());
        assertEquals(1, louvreMuseum.getCapacity());
        assertEquals(15, premiumPassenger.getBalance());
    }

    @Test
    public void testAddActivityWithFullCapacityAndDiscountedCost() {
        Activity louvreMuseum = new Activity("Louvre Museum", 10.0, 0, "Test Description", paris, false, true, false, true, false);
        premiumPassenger.setBalance(15);
        assertThrows(IllegalStateException.class, () -> premiumPassenger.addActivity(louvreMuseum));
        assertEquals(0, premiumPassenger.getActivities().size());
        assertEquals(15, premiumPassenger.getBalance());
    }

    @Test
    public void testSetBalance() {
        premiumPassenger.setBalance(50);
        assertEquals(50, premiumPassenger.getBalance());
    }
}
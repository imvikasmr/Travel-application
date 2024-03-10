import static org.junit.jupiter.api.Assertions.assertEquals;


import com.proj.java.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PassengerTests {
    private Passenger standardPassenger;
    private Passenger premiumPassenger;
    private Passenger goldPassenger;
    private Activity eiffelTower;

    @BeforeEach
    public void setUp() {
        Destination paris = new Destination("Paris");
        eiffelTower = new Activity("Eiffel Tower", 10.0, 2, "Test Description", paris, false, true, false, true, false);
        standardPassenger = new StandardPassenger("Alice", 1, 100);
        premiumPassenger = new PremiumPassenger("Bob", 2);
        goldPassenger = new GoldPassenger("Charlie", 3, 200);
    }

    @Test
    public void testGetName() {
        assertEquals("Alice", standardPassenger.getName());
        assertEquals("Bob", premiumPassenger.getName());
        assertEquals("Charlie", goldPassenger.getName());
    }

    @Test
    public void testGetPassengerNumber() {
        assertEquals(1, standardPassenger.getPassengerNumber());
        assertEquals(2, premiumPassenger.getPassengerNumber());
        assertEquals(3, goldPassenger.getPassengerNumber());
    }

    @Test
    public void testGetBalance() {
        assertEquals(100, standardPassenger.getBalance());
        assertEquals(100, premiumPassenger.getBalance());
        assertEquals(200, goldPassenger.getBalance());
    }
}
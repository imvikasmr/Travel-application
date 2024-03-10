
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.proj.java.Activity;
import com.proj.java.Destination;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DestinationTests {
    private Destination paris;
    private Destination rome;

    @BeforeEach
    public void setUp() {
        paris = new Destination("Paris");
        rome = new Destination("Rome");
    }

    @Test
    public void testGetName() {
        assertEquals("Paris", paris.getName());
    }

    @Test
    public void testGetActivities() {
        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity("Eiffel Tower", 10.0, 2, "Test Description", paris, false, true, false, true, false));
        paris.setActivities(activities);
        assertEquals(activities, paris.getActivities());
    }

    @Test
    public void testAddActivity() {
        Activity activity = new Activity("Eiffel Tower", 10.0, 2, "Test Description", paris, false, true, false, true, false);
        paris.addActivity(activity);
        assertEquals(activity, paris.getActivities().get(0));
    }

    @Test
    public void testEquals() {
        assertTrue(paris.equals(paris));
        assertTrue(paris.equals(new Destination("Paris")));
        assertFalse(paris.equals(rome));
        assertFalse(paris.equals(null));
        assertFalse(paris.equals(new Object()));
    }

    @Test
    public void testSetActivities() {
        Activity eiffelTower = new Activity("Eiffel Tower", 10.0, 2, "Test Description", paris, false, true, false, true, false);
        Activity louvreMuseum = new Activity("Louvre Museum", 15.0, 5, "Test Description", paris, false, true, false, true, false);
        List<Activity> activities = Arrays.asList(eiffelTower, louvreMuseum);

        paris.setActivities(activities);

        assertEquals(activities, paris.getActivities());
    }

    @Test
    public void testSetActivitiesNull() {
        assertThrows(NullPointerException.class, () -> paris.setActivities(null));
    }
}
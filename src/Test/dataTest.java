package Test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import Data.*;

public class dataTest {
    private vehicleQueue queue;

    public vehicle vehicle1;
    public vehicle vehicle2;

    @Before
    public void setUp() {
        queue = new vehicleQueue();
        vehicle1 = new vehicle("ABC123", "Car", 1);
        vehicle2 = new vehicle("XYZ456", "Truck", 3);
    }

    /// test vehicleQueue class
    @Test
    public void testEnqueue() {
        queue.enqueue(vehicle1);
        assertEquals(1, queue.size());

        queue.enqueue(vehicle2);
        assertEquals(2, queue.size());
    }

    @Test
    public void testDequeue() {
        queue.enqueue(vehicle1);
        vehicle dequeuedVehicle = queue.dequeue();
        assertEquals(vehicle1, dequeuedVehicle);
        assertEquals(0, queue.size());

        queue.enqueue(vehicle1);
        queue.enqueue(vehicle2);
        dequeuedVehicle = queue.dequeue();
        assertEquals(1, queue.size());

    }

    @Test
    public void testIsEmpty() {
        assertTrue(queue.isEmpty());
        queue.enqueue(vehicle1);
        assertFalse(queue.isEmpty());

        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    /// Test Vehcile class
    @Test
    public void testSetLicensePlate() {
        vehicle1.setLicensePlate("DEF456");
        assertEquals("DEF456", vehicle1.getLicensePlate());
    }

    @Test
    public void testSetType() {
        vehicle1.setType("Bus");
        assertEquals("Bus", vehicle1.getType());
    }

    @Test
    public void testSetSize() {
        vehicle1.setSize(2);
        assertEquals(2, vehicle1.getSize());
    }

}
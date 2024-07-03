package Data;

import java.util.LinkedList;
import java.util.Queue;

public class vehicleQueue {
    private Queue<vehicle> queue;

    public vehicleQueue() {
        this.queue = new LinkedList<>();
    }

    // Method to add a vehicle to the queue
    public void enqueue(vehicle Vehicle) {
        queue.offer(Vehicle);
    }

    // Method to remove and return the next vehicle in the queue
    public vehicle dequeue() {
        return queue.poll();
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // Method to get the size of the queue
    public int size() {
        return queue.size();
    }

    public Queue<vehicle> getQueue() {
        return queue;
    }

    // remove vehicles until there are only 10 in the queue
    public void removeVehicles() {
        while (queue.size() > 10) {
            queue.poll();
        }
    }

    // if called remove all cars but 1
    public void removeVehiclesExceptOne() {
        while (queue.size() > 1) {
            queue.poll();
        }
    }

    // Additional methods as needed
}

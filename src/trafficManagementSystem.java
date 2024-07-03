import javax.swing.*;
import java.awt.*;
import UI.*;
import Data.*;
import java.util.Random;

public class trafficManagementSystem extends JFrame {

    private vehicleQueue vehicleQueue;
    private vehicleFlowPanel flowPanel;

    public trafficManagementSystem() {
        setTitle("Traffic Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        getContentPane().setBackground(Color.WHITE); // Set background color of JFrame

        // Initialize UI components
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(1, 2)); // Two main sections side by side

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BorderLayout());

        // Add components to leftPanel (e.g., TrafficSignalsPanel, VehicleFlowPanel)
        trafficSignalsPanel signalsPanel = new trafficSignalsPanel();
        leftPanel.add(signalsPanel, BorderLayout.CENTER);

        flowPanel = new vehicleFlowPanel();
        leftPanel.add(flowPanel, BorderLayout.SOUTH);

        // Add components to rightPanel (e.g., CongestionPanel, AlertsPanel)
        congestionPanel congestionPanel = new congestionPanel();
        rightPanel.add(congestionPanel, BorderLayout.CENTER);

        alertsPanel alertsPanel = new alertsPanel();
        rightPanel.add(alertsPanel, BorderLayout.SOUTH);

        // Add leftPanel and rightPanel to topPanel
        topPanel.add(leftPanel);
        topPanel.add(rightPanel);

        // Add topPanel to mainPanel
        mainPanel.add(topPanel, BorderLayout.CENTER);

        // Add mainPanel to the frame
        add(mainPanel);

        // Initialize vehicle queue
        vehicleQueue = new vehicleQueue();

        Timer timer = new Timer(1000, e -> runSimulation());
        timer.start(); // Start the timer to update vehicle flow every second

        setVisible(true);
    }

    // Simulation method to update the vehicle queue
    private void runSimulation() {
        // Add new vehicles to the queue (for example, every second)
        String[] vehicleTypes = { "Sedan", "Truck", "Bus", "Motorcycle" };
        String licensePlate = "XYZ" + new Random().nextInt(999); // Generate a random license plate
        String vehicleType = vehicleTypes[new Random().nextInt(vehicleTypes.length)];
        vehicle newVehicle = new vehicle(licensePlate, vehicleType, Math.random() < 0.5 ? 1 : 2);
        vehicleQueue.enqueue(newVehicle);

        // Optionally, remove old vehicles from the queue
        if (vehicleQueue.size() > 10) { // For example, keep only the latest 10 vehicles
            vehicleQueue.removeVehicles();
        }
        flowPanel.updateVehicleFlow(vehicleQueue.getQueue());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new trafficManagementSystem();
        });
    }
}

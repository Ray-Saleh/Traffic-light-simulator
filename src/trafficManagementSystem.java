import javax.swing.*;
import java.awt.*;
import UI.*;
import Data.*;
import Logic.*;
import java.util.Random;

public class trafficManagementSystem extends JFrame {

    private vehicleQueue vehicleQueue;
    private vehicleFlowPanel flowPanel;
    private signalController signalController;

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

        // Initialize signal controller with a single signal
        signalController = new signalController(vehicleQueue, flowPanel);
        signalController.addSignal(new trafficSignal(10, 3, 7)); // Example durations

        // Register TrafficSignalsPanel with SignalController
        signalController.setTrafficSignalsPanel(signalsPanel);

        // Start the signal controller
        signalController.start();

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

        flowPanel.updateVehicleFlow(vehicleQueue.getQueue());

        if (vehicleQueue.size() >= 7) {
            // Force the signal to green
            signalController.forceGreenSignal();

            // Start a timer to turn the signal to yellow after 5-10 seconds
            new Timer(new Random().nextInt(6) + 5 * 1000, e -> {
                signalController.forceYellowSignal();

                // Start another timer to turn the signal to red after 3-5 seconds
                new Timer(new Random().nextInt(3) + 3 * 1000, ev -> {
                    signalController.forceRedSignal();
                }).start();
            }).start();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new trafficManagementSystem();
        });
    }
}

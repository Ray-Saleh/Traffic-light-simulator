import javax.swing.*;
import java.awt.*;
import UI.*;
import Data.*;
import java.util.Queue;

public class trafficManagementSystem extends JFrame {

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

        vehicleFlowPanel flowPanel = new vehicleFlowPanel();
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

        // Example integration with VehicleQueue
        vehicleQueue vQueue = new vehicleQueue();
        for (int i = 0; i < 5; i++) {
            vQueue.enqueue(new vehicle("ABC123" + i, "Car", 1)); // Example: Add vehicles to the queue
        }

        // Example: Update vehicle flow in UI every second (simulated)
        Timer timer = new Timer(1000, e -> {
            // Update vehicle flow information in the UI
            if (vQueue != null) {
                Queue<vehicle> vehicles = vQueue.getQueue(); // Example: Get vehicles from queue
                flowPanel.updateVehicleFlow(vehicles); // Update flowPanel with vehicle details
            }
        });
        timer.start();

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new trafficManagementSystem();
        });
    }
}

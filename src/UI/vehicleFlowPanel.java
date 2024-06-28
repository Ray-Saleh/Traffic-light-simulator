package UI;

import java.util.Queue;
import Data.*;
import javax.swing.*;
import java.awt.*;

public class vehicleFlowPanel extends JPanel {
    private JLabel vehicleCountLabel;
    private JTextArea vehicleDetailsArea;

    public vehicleFlowPanel() {
        // Set layout and preferred size
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(300, 200));

        // Initialize components
        vehicleCountLabel = new JLabel("Vehicle Count:");
        vehicleDetailsArea = new JTextArea(10, 30);
        vehicleDetailsArea.setEditable(false); // Make it read-only
        JScrollPane scrollPane = new JScrollPane(vehicleDetailsArea);

        // Add components to panel
        add(vehicleCountLabel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    // Method to update vehicle flow count and details
    public void updateVehicleFlow(Queue<vehicle> vehicles) {
        // Update vehicle count label
        vehicleCountLabel.setText("Vehicle Count: " + vehicles.size());

        // Update vehicle details area
        StringBuilder detailsBuilder = new StringBuilder();
        for (vehicle vehicle : vehicles) {
            detailsBuilder.append("Type: ").append(vehicle.getType())
                    .append(", License Plate: ").append(vehicle.getLicensePlate())
                    .append("\n");
        }
        vehicleDetailsArea.setText(detailsBuilder.toString());
    }
}

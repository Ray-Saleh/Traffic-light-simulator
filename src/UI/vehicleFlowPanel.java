package UI;

import javax.swing.*;

public class vehicleFlowPanel extends JPanel {
    public vehicleFlowPanel() {
        // Initialize and add components (e.g., JLabels or JTables for vehicle flow
        // information)
        JLabel flowLabel = new JLabel("Vehicle Flow Information:");
        JTextArea flowTextArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(flowTextArea);

        add(flowLabel);
        add(scrollPane);
    }
}

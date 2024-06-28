package UI;

import javax.swing.*;

public class trafficSignalsPanel extends JPanel {
    public trafficSignalsPanel() {
        // Initialize and add components (e.g., JLabels for traffic lights)
        JLabel redLight = new JLabel("Red Light");
        JLabel yellowLight = new JLabel("Yellow Light");
        JLabel greenLight = new JLabel("Green Light");

        add(redLight);
        add(yellowLight);
        add(greenLight);
    }
}

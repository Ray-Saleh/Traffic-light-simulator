package UI;

import javax.swing.*;

public class congestionPanel extends JPanel {
    public congestionPanel() {
        // Initialize and add components (e.g., JLabels or JProgressBar for congestion
        // status)
        JLabel congestionLabel = new JLabel("Congestion Status:");
        JProgressBar congestionBar = new JProgressBar(0, 100);
        congestionBar.setValue(50); // Example value

        add(congestionLabel);
        add(congestionBar);
    }
}

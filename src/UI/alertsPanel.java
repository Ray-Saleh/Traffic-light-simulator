package UI;

import javax.swing.*;

public class alertsPanel extends JPanel {
    public alertsPanel() {
        // Initialize and add components (e.g., JTextArea for displaying alerts)
        JLabel alertsLabel = new JLabel("Alerts and Notifications:");
        JTextArea alertsTextArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(alertsTextArea);

        add(alertsLabel);
        add(scrollPane);
    }
}

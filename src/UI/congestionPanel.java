package UI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class congestionPanel extends JPanel {
    private JLabel congestionLabel;
    private JProgressBar congestionBar;

    public congestionPanel() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(200, 40)); // Set preferred size for the panel

        congestionLabel = new JLabel("Congestion Status:");
        add(congestionLabel, BorderLayout.NORTH);

        JPanel barPanel = new JPanel(new BorderLayout());
        barPanel.setPreferredSize(new Dimension(200, 10)); // Adjust width and height as needed

        // Create an empty progress bar without text
        congestionBar = new JProgressBar();
        congestionBar.setPreferredSize(new Dimension(200, 10)); // Adjust width and height as needed
        congestionBar.setStringPainted(false); // Disable text display

        // Add a border to the progress bar panel
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        barPanel.setBorder(border);
        barPanel.add(congestionBar, BorderLayout.CENTER);

        add(barPanel, BorderLayout.CENTER);

        updateCongestionLevel(0); // Initialize with 0 cars
    }

    public void updateCongestionLevel(int numCars) {
        // Adjust the progress bar value based on congestion level
        int percent = (int) Math.round((double) numCars / 10 * 100); // Assuming max is 10 cars
        congestionBar.setValue(percent);

        // Color coding based on congestion level
        if (numCars >= 0 && numCars <= 4) {
            congestionBar.setForeground(Color.GREEN);
        } else if (numCars >= 5 && numCars <= 7) {
            congestionBar.setForeground(Color.YELLOW);
        } else if (numCars >= 8 && numCars <= 10) {
            congestionBar.setForeground(Color.RED);
        } else {
            congestionBar.setForeground(Color.GRAY); // Default color for out-of-range values
        }

        revalidate(); // Ensure the UI updates properly
        repaint();
    }
}

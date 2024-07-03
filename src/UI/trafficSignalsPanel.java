package UI;

import javax.swing.*;
import java.awt.*;
import Logic.trafficSignal; // Import TrafficSignal enum from Logic package

public class trafficSignalsPanel extends JPanel {
    private JLabel signalLabel;

    public trafficSignalsPanel() {
        signalLabel = new JLabel("Signal: RED", SwingConstants.CENTER);
        signalLabel.setOpaque(true);
        signalLabel.setBackground(Color.RED);
        signalLabel.setForeground(Color.WHITE);
        signalLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(signalLabel);
    }

    public void updateSignalState(trafficSignal.SignalColor state) {
        switch (state) {
            case RED:
                signalLabel.setText("Signal: RED");
                signalLabel.setBackground(Color.RED);
                signalLabel.setForeground(Color.WHITE);
                break;
            case YELLOW:
                signalLabel.setText("Signal: YELLOW");
                signalLabel.setBackground(Color.YELLOW);
                signalLabel.setForeground(Color.BLACK);
                break;
            case GREEN:
                signalLabel.setText("Signal: GREEN");
                signalLabel.setBackground(Color.GREEN);
                signalLabel.setForeground(Color.BLACK);
                break;
        }
    }
}

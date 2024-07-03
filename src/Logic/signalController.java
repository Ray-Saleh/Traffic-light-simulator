package Logic;

import Data.vehicle;
import Data.vehicleQueue;
import UI.trafficSignalsPanel;
import UI.vehicleFlowPanel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class signalController {
    private vehicleQueue vehicleQueue;
    private vehicleFlowPanel flowPanel;
    private trafficSignalsPanel trafficSignalsPanel;
    private List<trafficSignal> signals;

    public signalController(vehicleQueue vehicleQueue, vehicleFlowPanel flowPanel) {
        this.vehicleQueue = vehicleQueue;
        this.flowPanel = flowPanel;
        this.signals = new ArrayList<>();
    }

    public void addSignal(trafficSignal signal) {
        signals.add(signal);
    }

    public void setTrafficSignalsPanel(trafficSignalsPanel trafficSignalsPanel) {
        this.trafficSignalsPanel = trafficSignalsPanel;
    }

    public void start() {
        new Timer(1000, e -> updateSignals()).start();
    }

    public void updateSignals() {
        if (!signals.isEmpty()) {
            trafficSignal signal = signals.get(0);
            signal.updateState();

            // Update UI based on signal state
            updateUI(signal);

            // Dequeue vehicles if the signal is green
            if (signal.getColor() == trafficSignal.SignalColor.GREEN) {
                vehicleQueue.removeVehiclesExceptOne();
                vehicleQueue.dequeue();
            } else if (signal.getColor() == trafficSignal.SignalColor.YELLOW) {
                int carsRun = 0;
                while (carsRun < 3 && !vehicleQueue.isEmpty()) {
                    vehicleQueue.dequeue();
                    carsRun++;
                }
            }

        }
    }

    private void updateUI(trafficSignal signal) {
        if (trafficSignalsPanel != null) {
            trafficSignalsPanel.updateSignalState(signal.getColor());
        }
    }

    public void forceGreenSignal() {
        if (!signals.isEmpty()) {
            trafficSignal signal = signals.get(0);
            signal.forceGreen();
            updateUI(signal);
        }
    }

    public void forceYellowSignal() {
        if (!signals.isEmpty()) {
            trafficSignal signal = signals.get(0);
            signal.forceYellow();
            updateUI(signal);
        }
    }

    public void forceRedSignal() {
        if (!signals.isEmpty()) {
            trafficSignal signal = signals.get(0);
            signal.forceRed();
            updateUI(signal);
        }
    }

    public trafficSignal.SignalColor getColor() {
        if (!signals.isEmpty()) {
            return signals.get(0).getColor();
        }
        return null;
    }
}

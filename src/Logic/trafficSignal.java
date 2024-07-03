package Logic;

public class trafficSignal {
    public enum SignalColor {
        RED, YELLOW, GREEN
    }

    private SignalColor color;
    private int greenDuration;
    private int yellowDuration;
    private int redDuration;

    private int timer;

    public trafficSignal(int greenDuration, int yellowDuration, int redDuration) {
        this.greenDuration = greenDuration;
        this.yellowDuration = yellowDuration;
        this.redDuration = redDuration;
        this.color = SignalColor.RED;
        this.timer = redDuration;
    }

    public SignalColor getColor() {
        return color;
    }

    public void updateState() {
        timer--;
        if (timer <= 0) {
            switch (color) {
                case RED:
                    color = SignalColor.GREEN;
                    timer = greenDuration;
                    break;
                case GREEN:
                    color = SignalColor.YELLOW;
                    timer = yellowDuration;
                    break;
                case YELLOW:
                    color = SignalColor.RED;
                    timer = redDuration;
                    break;
            }
        }
    }

    public void forceGreen() {
        color = SignalColor.GREEN;
        timer = greenDuration;
    }

    public void forceYellow() {
        color = SignalColor.YELLOW;
        timer = yellowDuration;
    }

    public void forceRed() {
        color = SignalColor.RED;
        timer = redDuration;
    }
}

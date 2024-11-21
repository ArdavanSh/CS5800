import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TrafficLightObservable {

    public enum SignalColor {
        RED, GREEN, YELLOW
    }

    private SignalColor currentColor;
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private final Random random;

    public TrafficLightObservable() {
        currentColor = SignalColor.RED;
        random = new Random();
        System.out.println("Traffic light system started...");
        start();
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }


    private void start() {
        while (true) {
            SignalColor oldColor = currentColor;
            displayCurrentColor();
            waitForRandomTime();
            transitionToNextColor();
            support.firePropertyChange("currentColor", oldColor, currentColor);
        }
    }

    private void displayCurrentColor() {
        System.out.println("Current Light: " + currentColor);
    }

    private void waitForRandomTime() {
        int delay = random.nextInt(4);
        try {
            TimeUnit.SECONDS.sleep(delay);
        } catch (InterruptedException e) {}
    }

    private void transitionToNextColor() {
        switch (currentColor) {
            case RED:
                currentColor = SignalColor.GREEN;
                break;
            case GREEN:
                currentColor = SignalColor.YELLOW;
                break;
            case YELLOW:
                currentColor = SignalColor.RED;
                break;
        }
    }
}


import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TrafficLight {
    private enum SignalColor {
        RED, GREEN, YELLOW
    }

    private SignalColor currentColor;
    private final Random random;

    public TrafficLight() {
        currentColor = SignalColor.RED;
        random = new Random();
        start();
    }

    private void start() {
        while (true) {
            displayCurrentColor();
            waitForRandomTime();
            transitionToNextColor();
        }
    }

    private void displayCurrentColor() {
        System.out.println("Current Light: " + currentColor);
    }

    private void waitForRandomTime() {
        int delay = random.nextInt(4) ;
        try {
            TimeUnit.SECONDS.sleep(delay);
        } catch (InterruptedException e) {
        }
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


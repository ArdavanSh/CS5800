package part3;

public class PassiveBehavior implements DrivingBehavior {
    public String decideAction(String signal) {
        switch (signal) {
            case "RED":
                return "Stop";
            case "YELLOW":
                return "Slower";
            case "GREEN":
                return "Go Slow";
            default:
                return "Unknown signal";
        }
    }
}

package part3;

public class AggressiveBehavior implements DrivingBehavior {
    public String decideAction(String signal) {
        switch (signal) {
            case "RED":
                return "Slam Brake";
            case "YELLOW":
                return "Faster";
            case "GREEN":
                return "Need4Speed";
            default:
                return "Unknown signal";
        }
    }
}


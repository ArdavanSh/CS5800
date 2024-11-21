package part3;

public class NormalBehavior implements DrivingBehavior {
    public String decideAction(String signal) {
        switch (signal) {
            case "RED":
                return "Stop";
            case "YELLOW":
                return "Slow";
            case "GREEN":
                return "Go";
            default:
                return "Unknown signal";
        }
    }
}



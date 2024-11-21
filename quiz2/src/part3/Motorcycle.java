package part3;


public class Motorcycle extends Vehicle {
    public Motorcycle(DrivingBehavior drivingBehavior) {
        super(drivingBehavior);
    }

    @Override
    public String getVehicleType() {
        return "Motorcycle";
    }
}


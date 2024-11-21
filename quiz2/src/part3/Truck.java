package part3;


public class Truck extends Vehicle {
    public Truck(DrivingBehavior drivingBehavior) {
        super(drivingBehavior);
    }

    @Override
    public String getVehicleType() {
        return "Truck";
    }
}


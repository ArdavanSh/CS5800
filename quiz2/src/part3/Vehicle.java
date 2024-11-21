package part3;


public abstract class Vehicle {
    private DrivingBehavior drivingBehavior;

    public Vehicle(DrivingBehavior drivingBehavior) {
        this.drivingBehavior = drivingBehavior;
    }

    public void setDrivingBehavior(DrivingBehavior drivingBehavior) {
        this.drivingBehavior = drivingBehavior;
    }

    public abstract String getVehicleType();
}




package part3;


public class Car extends Vehicle {
    public Car(DrivingBehavior drivingBehavior) {
        super(drivingBehavior);
    }

    @Override
    public String getVehicleType() {
        return "Car";
    }
}



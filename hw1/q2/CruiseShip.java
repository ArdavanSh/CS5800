public class CruiseShip extends Ship {
    private int maxPassengers;


    public CruiseShip(String name, String yearBuilt, int maxPassengers) {
        super(name, yearBuilt); // Call the parent constructor
        this.maxPassengers = maxPassengers;
    }


    public int getMaxPassengers() {
        return maxPassengers;
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    @Override
    public void print(){
        System.out.println("Cruise Ship Name: " + getName() + ", Max Passengers: " + maxPassengers);
    }
}

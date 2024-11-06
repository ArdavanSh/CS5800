public class HotDog implements FoodItem {
    @Override
    public double getCost() {
        return 3.00; // Base price for a hot dog
    }

    @Override
    public String getDescription() {
        return "Hot Dog";
    }
}


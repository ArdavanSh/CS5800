public class Fries implements FoodItem {
    @Override
    public double getCost() {
        return 2.50; // Base price for fries
    }

    @Override
    public String getDescription() {
        return "Fries";
    }
}


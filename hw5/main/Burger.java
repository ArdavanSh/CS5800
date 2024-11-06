public class Burger implements FoodItem {
    @Override
    public double getCost() {
        return 5.00; // Base price for a burger
    }

    @Override
    public String getDescription() {
        return "Burger";
    }
}

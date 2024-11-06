public class Bacon extends ToppingDecorator {
    public Bacon(FoodItem newFoodItem) {
        super(newFoodItem);
    }

    @Override
    public double getCost() {
        return tempFoodItem.getCost() + 1.00; // Additional cost for bacon
    }

    @Override
    public String getDescription() {
        return tempFoodItem.getDescription() + ", Bacon";
    }
}


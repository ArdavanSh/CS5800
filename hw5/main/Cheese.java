public class Cheese extends ToppingDecorator {
    public Cheese(FoodItem newFoodItem) {
        super(newFoodItem);
    }

    @Override
    public double getCost() {
        return tempFoodItem.getCost() + 0.50; // Additional cost for cheese
    }

    @Override
    public String getDescription() {
        return tempFoodItem.getDescription() + ", Cheese";
    }
}


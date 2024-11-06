public class Lettuce extends ToppingDecorator {
    public Lettuce(FoodItem newFoodItem) {
        super(newFoodItem);
    }

    @Override
    public double getCost() {
        return tempFoodItem.getCost() + 0.25; // Additional cost for lettuce
    }

    @Override
    public String getDescription() {
        return tempFoodItem.getDescription() + ", Lettuce";
    }
}


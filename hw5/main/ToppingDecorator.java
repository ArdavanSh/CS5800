public abstract class ToppingDecorator implements FoodItem {
    protected FoodItem tempFoodItem;

    public ToppingDecorator(FoodItem newFoodItem) {
        tempFoodItem = newFoodItem;
    }

    @Override
    public double getCost() {
        return tempFoodItem.getCost();
    }

    @Override
    public String getDescription() {
        return tempFoodItem.getDescription();
    }
}


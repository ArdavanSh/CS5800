import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<FoodItem> foodItems;

    public Order() {
        foodItems = new ArrayList<FoodItem>();
    }

    public void addItem(FoodItem item) {
        foodItems.add(item);
    }

    public double getTotalCost() {
        double total = 0.0;
        for (FoodItem item : foodItems) {
            total += item.getCost();
        }
        return total;
    }

    public void printOrder() {
        for (FoodItem item : foodItems) {
            System.out.println(item.getDescription() + ": $" + item.getCost());
        }
        System.out.println("Total: $" + getTotalCost());
    }
}


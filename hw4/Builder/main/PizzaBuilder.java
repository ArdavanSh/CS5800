import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PizzaBuilder {
    private final List<String> toppings = new ArrayList<>();
    private Pizza.Size pizzaSize;
    private static final Set<String> validToppings = Set.of(
            "Pepperoni", "Sausage", "Mushrooms", "Bacon", "Onions", "ExtraCheese", "Peppers",
            "Chicken", "Olives", "Spinach", "Tomato and Basil", "Beef", "Ham", "Pesto",
            "Spicy Pork", "Ham and Pineapple"
    );

    public PizzaBuilder addTopping(String topping) {
        if (validToppings.contains(topping)) {
            toppings.add(topping);
        }
        return this;
    }

    public PizzaBuilder addAllToppings(String[] topping) {
        for (String top : topping) {
            if (validToppings.contains(top)) {
                toppings.add(top);
            }
        }
        return this;
    }

    public PizzaBuilder setPizzaSize(Pizza.Size pizzaSize) {
        this.pizzaSize = pizzaSize;
        return this;
    }

    public Pizza createPizza() {
        if (pizzaSize == null) {
            throw new IllegalStateException("Pizza size must be set.");
        }
        return new Pizza(pizzaSize, toppings);
    }
}


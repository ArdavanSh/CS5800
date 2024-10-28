public class PizzaDriver {
    public static void main(String[] args) {

        System.out.println("Part1: ");

        // Create a PizzaHut instance
        PizzaChain pizzaHut = new PizzaHut();

        // Create a medium pizza with 3 toppings
        Pizza smallPizza = pizzaHut.buildPizza(Pizza.Size.SMALL, new String[]{"Pepperoni", "Mushrooms", "Onions"});

        // Create a large pizza with 6 toppings
        Pizza mediumPizza = pizzaHut.buildPizza(Pizza.Size.MEDIUM, new String[]{"Pepperoni", "Mushrooms", "Onions", "Bacon", "Sausage", "Olives"});

        // Create a small pizza with 9 toppings
        Pizza largePizza = pizzaHut.buildPizza(Pizza.Size.LARGE, new String[]{
                "Pepperoni", "Mushrooms", "Onions", "Bacon", "Sausage", "Olives", "Peppers", "Chicken", "Spinach"
        });

        // Serve (eat) each pizza
        pizzaHut.servePizza(smallPizza);
        pizzaHut.servePizza(mediumPizza);
        pizzaHut.servePizza(largePizza);


        System.out.println("\n\nPart2: ");

        PizzaChain littleCaesars = new LittleCaesars();
        PizzaChain dominos = new Dominos();

        // Pizza Hut: Large pizza with 3 toppings, Small pizza with 2 toppings
        Pizza pizzaHutLarge = pizzaHut.buildPizza(Pizza.Size.LARGE, new String[]{"Pepperoni", "Mushrooms", "Bacon"});
        Pizza pizzaHutSmall = pizzaHut.buildPizza(Pizza.Size.SMALL, new String[]{"Onions", "Peppers"});

        // Little Caesars: Medium pizza with 8 toppings, Small pizza with 6 toppings
        Pizza littleCaesarsMedium = littleCaesars.buildPizza(Pizza.Size.MEDIUM, new String[]{
                "Pepperoni", "Sausage", "Mushrooms", "Bacon", "Onions", "ExtraCheese", "Peppers", "Chicken"
        });
        Pizza littleCaesarsSmall = littleCaesars.buildPizza(Pizza.Size.SMALL, new String[]{
                "Olives", "Spinach", "Tomato and Basil", "Beef", "Ham", "Pesto"
        });

        // Dominos: Small pizza with 1 topping, Large pizza with 3 toppings
        Pizza dominosSmall = dominos.buildPizza(Pizza.Size.SMALL, new String[]{"Bacon"});
        Pizza dominosLarge = dominos.buildPizza(Pizza.Size.LARGE, new String[]{"Spicy Pork", "Ham", "Pineapple"});

        // Serve (eat) each pizza
        pizzaHut.servePizza(pizzaHutLarge);
        pizzaHut.servePizza(pizzaHutSmall);

        littleCaesars.servePizza(littleCaesarsMedium);
        littleCaesars.servePizza(littleCaesarsSmall);

        dominos.servePizza(dominosSmall);
        dominos.servePizza(dominosLarge);

    }
}

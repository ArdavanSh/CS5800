public class LittleCaesars extends PizzaChain {

    public LittleCaesars() {
        super("Little Caesars");
    }

    @Override
    public Pizza buildPizza(Pizza.Size size, String[] toppings) {
        PizzaBuilder builder = new PizzaBuilder()
                .setPizzaSize(size)
                .addAllToppings(toppings);
        return builder.createPizza();
    }
}

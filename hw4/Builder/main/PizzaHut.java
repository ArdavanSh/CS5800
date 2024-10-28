public class PizzaHut extends PizzaChain {

    public PizzaHut() {
        super("Pizza Hut");
    }

    @Override
    public Pizza buildPizza(Pizza.Size size, String[] toppings) {
        PizzaBuilder builder = new PizzaBuilder()
                .setPizzaSize(size)
                .addAllToppings(toppings);
        return builder.createPizza();
    }
}

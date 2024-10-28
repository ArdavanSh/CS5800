public class Dominos extends PizzaChain {

    public Dominos() {
        super("Dominos");
    }

    @Override
    public Pizza buildPizza(Pizza.Size size, String[] toppings) {
        PizzaBuilder builder = new PizzaBuilder()
                .setPizzaSize(size)
                .addAllToppings(toppings);
        return builder.createPizza();
    }
}

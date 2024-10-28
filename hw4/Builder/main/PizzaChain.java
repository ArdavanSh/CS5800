public abstract class PizzaChain {
    private final String name;

    public PizzaChain(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract Pizza buildPizza(Pizza.Size size, String[] toppings);

    public void servePizza(Pizza pizza) {
        System.out.println("Serving a pizza from " + name);
        pizza.eat();
    }
}


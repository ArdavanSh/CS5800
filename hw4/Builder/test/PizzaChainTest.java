import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class PizzaChainTest {
    private PizzaChain pizzaHut;
    private PizzaChain littleCaesars;
    private PizzaChain dominos;

    @BeforeEach
    public void setUp() {
        pizzaHut = new PizzaHut();
        littleCaesars = new LittleCaesars();
        dominos = new Dominos();
    }

    // Test the chain names
    @Test
    public void testChainNames() {
        assertEquals("Pizza Hut", pizzaHut.getName());
        assertEquals("Little Caesars", littleCaesars.getName());
        assertEquals("Dominos", dominos.getName());
    }

    // Test Pizza Hut: Large pizza with 3 toppings
    @Test
    public void testPizzaHutLargePizza() {
        Pizza pizza = pizzaHut.buildPizza(Pizza.Size.LARGE, new String[]{"Pepperoni", "Mushrooms", "Bacon"});
        assertEquals(Pizza.Size.LARGE, pizza.getSize());
        assertEquals(List.of("Pepperoni", "Mushrooms", "Bacon"), pizza.getToppings());
    }

    // Test Pizza Hut: Small pizza with 2 toppings
    @Test
    public void testPizzaHutSmallPizza() {
        Pizza pizza = pizzaHut.buildPizza(Pizza.Size.SMALL, new String[]{"Onions", "Peppers"});
        assertEquals(Pizza.Size.SMALL, pizza.getSize());
        assertEquals(List.of("Onions", "Peppers"), pizza.getToppings());
    }

    // Test Little Caesars: Medium pizza with 8 toppings
    @Test
    public void testLittleCaesarsMediumPizza() {
        Pizza pizza = littleCaesars.buildPizza(Pizza.Size.MEDIUM, new String[]{
                "Pepperoni", "Sausage", "Mushrooms", "Bacon", "Onions", "ExtraCheese", "Peppers", "Chicken"
        });
        assertEquals(Pizza.Size.MEDIUM, pizza.getSize());
        assertEquals(List.of("Pepperoni", "Sausage", "Mushrooms", "Bacon", "Onions", "ExtraCheese", "Peppers", "Chicken"), pizza.getToppings());
    }

    // Test Little Caesars: Small pizza with 6 toppings
    @Test
    public void testLittleCaesarsSmallPizza() {
        Pizza pizza = littleCaesars.buildPizza(Pizza.Size.SMALL, new String[]{
                "Olives", "Spinach", "Tomato and Basil", "Beef", "Ham", "Pesto"
        });
        assertEquals(Pizza.Size.SMALL, pizza.getSize());
        assertEquals(List.of("Olives", "Spinach", "Tomato and Basil", "Beef", "Ham", "Pesto"), pizza.getToppings());
    }

    // Test Dominos: Small pizza with 1 topping
    @Test
    public void testDominosSmallPizza() {
        Pizza pizza = dominos.buildPizza(Pizza.Size.SMALL, new String[]{"Bacon"});
        assertEquals(Pizza.Size.SMALL, pizza.getSize());
        assertEquals(List.of("Bacon"), pizza.getToppings());
    }

    // Test Dominos: Large pizza with 3 toppings
    @Test
    public void testDominosLargePizza() {
        Pizza pizza = dominos.buildPizza(Pizza.Size.LARGE, new String[]{"Spicy Pork", "Ham and Pineapple"});
        assertEquals(Pizza.Size.LARGE, pizza.getSize());
        assertEquals(List.of("Spicy Pork", "Ham and Pineapple"), pizza.getToppings());
    }

    // Test exception for missing pizza size in builder
    @Test
    public void testMissingPizzaSize() {
        PizzaBuilder builder = new PizzaBuilder();
        builder.addAllToppings(new String[]{"Pepperoni", "Mushrooms"});
        assertThrows(IllegalStateException.class, builder::createPizza, "Pizza size must be set.");
    }
}

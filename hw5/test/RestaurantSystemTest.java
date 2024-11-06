// RestaurantSystemTest.java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RestaurantSystemTest {

    @Test
    public void testBurgerBaseCost() {
        FoodItem burger = new Burger();
        assertEquals(5.00, burger.getCost(), 0.001, "Burger base cost should be $5.00");
        assertEquals("Burger", burger.getDescription(), "Description should be 'Burger'");
    }

    @Test
    public void testBurgerWithToppings() {
        FoodItem burger = new Burger();
        burger = new Cheese(burger);
        burger = new Bacon(burger);
        burger = new Lettuce(burger);
        assertEquals(6.75, burger.getCost(), 0.001, "Burger with Cheese, Bacon, and Lettuce should cost $6.75");
        assertEquals("Burger, Cheese, Bacon, Lettuce", burger.getDescription(), "Description should include all toppings");
    }

    @Test
    public void testFriesBaseCost() {
        FoodItem fries = new Fries();
        assertEquals(2.50, fries.getCost(), 0.001, "Fries base cost should be $2.50");
        assertEquals("Fries", fries.getDescription(), "Description should be 'Fries'");
    }

    @Test
    public void testHotDogWithCheese() {
        FoodItem hotDog = new HotDog();
        hotDog = new Cheese(hotDog);
        assertEquals(3.50, hotDog.getCost(), 0.001, "Hot Dog with Cheese should cost $3.50");
        assertEquals("Hot Dog, Cheese", hotDog.getDescription(), "Description should be 'Hot Dog, Cheese'");
    }

    @Test
    public void testOrderTotalCost() {
        FoodItem burger = new Burger();
        burger = new Cheese(burger);
        burger = new Bacon(burger);

        FoodItem fries = new Fries();

        FoodItem hotDog = new HotDog();
        hotDog = new Lettuce(hotDog);

        Order order = new Order();
        order.addItem(burger);
        order.addItem(fries);
        order.addItem(hotDog);

        double expectedTotal = (5.00 + 0.50 + 1.00) + 2.50 + (3.00 + 0.25);
        assertEquals(expectedTotal, order.getTotalCost(), 0.001, "Order total cost should be calculated correctly");
    }

    @Test
    public void testCustomerLoyaltyDiscount() {
        double totalCost = 100.00;
        CustomerLoyalty silverCustomer = new CustomerLoyalty(CustomerLoyalty.LoyaltyStatus.SILVER);
        CustomerLoyalty goldCustomer = new CustomerLoyalty(CustomerLoyalty.LoyaltyStatus.GOLD);
        CustomerLoyalty platinumCustomer = new CustomerLoyalty(CustomerLoyalty.LoyaltyStatus.PLATINUM);
        CustomerLoyalty regularCustomer = new CustomerLoyalty(CustomerLoyalty.LoyaltyStatus.REGULAR);

        assertEquals(95.00, silverCustomer.applyDiscount(totalCost), 0.001, "SILVER status should get 5% discount");
        assertEquals(90.00, goldCustomer.applyDiscount(totalCost), 0.001, "GOLD status should get 10% discount");
        assertEquals(85.00, platinumCustomer.applyDiscount(totalCost), 0.001, "PLATINUM status should get 15% discount");
        assertEquals(100.00, regularCustomer.applyDiscount(totalCost), 0.001, "REGULAR status should get no discount");
    }

    @Test
    public void testOrderWithDiscount() {
        FoodItem burger = new Burger();
        burger = new Cheese(burger);
        burger = new Bacon(burger);

        FoodItem fries = new Fries();

        Order order = new Order();
        order.addItem(burger);
        order.addItem(fries);

        double totalCost = order.getTotalCost(); // Expected: 5.00 + 0.50 + 1.00 + 2.50 = 9.00
        CustomerLoyalty customer = new CustomerLoyalty(CustomerLoyalty.LoyaltyStatus.PLATINUM);
        double discountedTotal = customer.applyDiscount(totalCost); // Expected: 9.00 * 0.85 = 7.65

        assertEquals(7.65, discountedTotal, 0.001, "Total after PLATINUM discount should be $7.65");
    }

    @Test
    public void testMultipleToppings() {
        FoodItem hotDog = new HotDog();
        hotDog = new Cheese(hotDog);
        hotDog = new Bacon(hotDog);
        hotDog = new Lettuce(hotDog);

        double expectedCost = 3.00 + 0.50 + 1.00 + 0.25;
        assertEquals(expectedCost, hotDog.getCost(), 0.001, "Hot Dog with multiple toppings should have correct cost");
        assertEquals("Hot Dog, Cheese, Bacon, Lettuce", hotDog.getDescription(), "Description should include all toppings");
    }

    @Test
    public void testEmptyOrder() {
        Order order = new Order();
        assertEquals(0.0, order.getTotalCost(), 0.001, "Empty order should have total cost of $0.00");
    }

    @Test
    public void testLoyaltyStatusGetter() {
        CustomerLoyalty customer = new CustomerLoyalty(CustomerLoyalty.LoyaltyStatus.GOLD);
        assertEquals(CustomerLoyalty.LoyaltyStatus.GOLD, customer.getStatus(), "Loyalty status getter should return correct status");
    }
}

// (Driver Program)
public class RestaurantSystem {
    public static void main(String[] args) {
        // Create base food items
        FoodItem burger = new Burger();
        FoodItem fries = new Fries();
        FoodItem hotDog = new HotDog();

        // Add toppings to food items using decorators
        burger = new Cheese(burger); // Add cheese to burger
        burger = new Bacon(burger);  // Add bacon to burger

        hotDog = new Cheese(hotDog); // Add cheese to hot dog

        // Create an order and add items
        Order order = new Order();
        order.addItem(burger);
        order.addItem(fries);
        order.addItem(hotDog);

        // Print the order before applying discount
        System.out.println("Order before discount:");
        order.printOrder();

        // Create a customer with GOLD loyalty status
        CustomerLoyalty customer = new CustomerLoyalty(CustomerLoyalty.LoyaltyStatus.GOLD);

        // Apply loyalty discount to the total order cost
        double discountedTotal = customer.applyDiscount(order.getTotalCost());
        System.out.printf("Total after %s discount: $%.2f%n", customer.getStatus(), discountedTotal);
    }
}



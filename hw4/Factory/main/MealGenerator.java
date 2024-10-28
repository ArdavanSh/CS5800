import food.*;

public class MealGenerator {
    public static void main(String[] args) {
        // Get factories
        MacronutrientFactory factory = MacronutrientFactory.getInstance();
        CarbohydrateFactory carbFactory = factory.getCarbohydrateFactory();
        ProteinFactory proteinFactory = factory.getProteinFactory();
        FatFactory fatFactory = factory.getFatFactory();

        // Create customers
        Customer customer1 = new Customer("Alice", DietPlan.NO_RESTRICTION);
        Customer customer2 = new Customer("Bob", DietPlan.PALEO);
        Customer customer3 = new Customer("Charlie", DietPlan.VEGAN);
        Customer customer4 = new Customer("David", DietPlan.NUT_ALLERGY);
        Customer customer5 = new Customer("Eve", DietPlan.PALEO);
        Customer customer6 = new Customer("Frank", DietPlan.VEGAN);

        // Generate meals for customers
        generateMeal(customer1, carbFactory, proteinFactory, fatFactory);
        generateMeal(customer2, carbFactory, proteinFactory, fatFactory);
        generateMeal(customer3, carbFactory, proteinFactory, fatFactory);
        generateMeal(customer4, carbFactory, proteinFactory, fatFactory);
        generateMeal(customer5, carbFactory, proteinFactory, fatFactory);
        generateMeal(customer6, carbFactory, proteinFactory, fatFactory);
    }

    private static void generateMeal(
            Customer customer,
            CarbohydrateFactory carbFactory,
            ProteinFactory proteinFactory,
            FatFactory fatFactory
    ) {
        Carbohydrate carb = carbFactory.createRandomCarbohydrate(customer.getDietPlan());
        Protein protein = proteinFactory.createRandomProtein(customer.getDietPlan());
        Fat fat = fatFactory.createRandomFat(customer.getDietPlan());

        System.out.println("Meal for " + customer.getName() + " (" + customer.getDietPlan() + "):");
        System.out.println("Carbohydrate: " + (carb != null ? carb.getName() : "None available"));
        System.out.println("Protein: " + (protein != null ? protein.getName() : "None available"));
        System.out.println("Fat: " + (fat != null ? fat.getName() : "None available"));
        System.out.println();
    }
}


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Set;
import food.*;

public class MealGeneratorTest {

    @Test
    public void testMealGenerationNoRestriction() {
        Customer customer = new Customer("TestUser", DietPlan.NO_RESTRICTION);
        MacronutrientFactory factory = MacronutrientFactory.getInstance();
        Carbohydrate carb = factory.getCarbohydrateFactory().createRandomCarbohydrate(customer.getDietPlan());
        Protein protein = factory.getProteinFactory().createRandomProtein(customer.getDietPlan());
        Fat fat = factory.getFatFactory().createRandomFat(customer.getDietPlan());

        assertNotNull(carb);
        assertNotNull(protein);
        assertNotNull(fat);
        // No restrictions, so any items are acceptable
    }

    @Test
    public void testMealGenerationVegan() {
        Customer customer = new Customer("TestUser", DietPlan.VEGAN);
        MacronutrientFactory factory = MacronutrientFactory.getInstance();

        for (int i = 0; i < 10; i++) {
            Carbohydrate carb = factory.getCarbohydrateFactory().createRandomCarbohydrate(customer.getDietPlan());
            Protein protein = factory.getProteinFactory().createRandomProtein(customer.getDietPlan());
            Fat fat = factory.getFatFactory().createRandomFat(customer.getDietPlan());

            assertNotNull(carb);
            assertNotNull(protein);
            assertNotNull(fat);

            assertFalse(carb.isDairy(), "Vegan diet should not allow dairy in carbs");
            assertFalse(protein.isMeat(), "Vegan diet should not allow meat proteins");
            assertFalse(fat.isMeat(), "Vegan diet should not allow meat fats");
            assertFalse(fat.isDairy(), "Vegan diet should not allow dairy in fats");
        }
    }

    @Test
    public void testMealGenerationPaleo() {
        Customer customer = new Customer("TestUser", DietPlan.PALEO);
        MacronutrientFactory factory = MacronutrientFactory.getInstance();

        for (int i = 0; i < 10; i++) {
            Carbohydrate carb = factory.getCarbohydrateFactory().createRandomCarbohydrate(customer.getDietPlan());
            Protein protein = factory.getProteinFactory().createRandomProtein(customer.getDietPlan());
            Fat fat = factory.getFatFactory().createRandomFat(customer.getDietPlan());

            assertNotNull(carb);
            assertNotNull(protein);
            assertNotNull(fat);

            assertEquals("Pistachio", carb.getName(), "Paleo diet should only allow Pistachio for carbs");
            assertFalse(protein.isTofu(), "Paleo diet should not allow Tofu in proteins");
            assertFalse(fat.isDairy(), "Paleo diet should not allow dairy in fats");
        }
    }

    @Test
    public void testMealGenerationNutAllergy() {
        Customer customer = new Customer("TestUser", DietPlan.NUT_ALLERGY);
        MacronutrientFactory factory = MacronutrientFactory.getInstance();

        for (int i = 0; i < 10; i++) {
            Carbohydrate carb = factory.getCarbohydrateFactory().createRandomCarbohydrate(customer.getDietPlan());
            Protein protein = factory.getProteinFactory().createRandomProtein(customer.getDietPlan());
            Fat fat = factory.getFatFactory().createRandomFat(customer.getDietPlan());

            assertNotNull(carb);
            assertNotNull(protein);
            assertNotNull(fat);

            assertFalse(carb.isNut(), "Nut Allergy diet should not allow nuts in carbs");
            // Proteins have no nuts, so no need to test proteins for nuts
            assertFalse(fat.isNut(), "Nut Allergy diet should not allow nuts in fats");
        }
    }

    @Test
    public void testProteinFactoryVeganRandomness() {
        ProteinFactory factory = ProteinFactory.getInstance();
        Set<String> producedItems = new HashSet<>();

        for (int i = 0; i < 100; i++) {
            Protein protein = factory.createRandomProtein(DietPlan.VEGAN);
            assertNotNull(protein);
            assertFalse(protein.isMeat(), "Vegan diet should not allow meat proteins");
            producedItems.add(protein.getName());
        }

        // Ensure that Tofu is among the produced items
        assertTrue(producedItems.contains("Tofu"), "Tofu should be produced in vegan diet");
    }

    @Test
    public void testFatFactoryNutAllergyRandomness() {
        FatFactory factory = FatFactory.getInstance();
        Set<String> producedItems = new HashSet<>();

        for (int i = 0; i < 100; i++) {
            Fat fat = factory.createRandomFat(DietPlan.NUT_ALLERGY);
            assertNotNull(fat);
            assertFalse(fat.isNut(), "Nut Allergy diet should not allow nuts in fats");
            producedItems.add(fat.getName());
        }

        // Ensure that multiple different fats are produced
        assertTrue(producedItems.size() > 1, "Should produce multiple different fats");
    }
}



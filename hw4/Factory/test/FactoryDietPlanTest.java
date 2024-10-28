import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import food.*;

public class FactoryDietPlanTest {

    @Test
    public void testCarbohydrateFactoryNoRestriction() {
        CarbohydrateFactory factory = CarbohydrateFactory.getInstance();
        Carbohydrate carb = factory.createRandomCarbohydrate(DietPlan.NO_RESTRICTION);
        assertNotNull(carb);
    }

    @Test
    public void testCarbohydrateFactoryPaleo() {
        CarbohydrateFactory factory = CarbohydrateFactory.getInstance();
        for (int i = 0; i < 10; i++) { // Test multiple times due to randomness
            Carbohydrate carb = factory.createRandomCarbohydrate(DietPlan.PALEO);
            assertNotNull(carb);
            assertEquals("Pistachio", carb.getName(), "Paleo diet should only allow Pistachio for carbs");
        }
    }

    @Test
    public void testProteinFactoryVegan() {
        ProteinFactory factory = ProteinFactory.getInstance();
        for (int i = 0; i < 10; i++) {
            Protein protein = factory.createRandomProtein(DietPlan.VEGAN);
            assertNotNull(protein);
            assertFalse(protein.isMeat(), "Vegan diet should not allow meat proteins");
        }
    }

    @Test
    public void testFatFactoryNutAllergy() {
        FatFactory factory = FatFactory.getInstance();
        for (int i = 0; i < 10; i++) {
            Fat fat = factory.createRandomFat(DietPlan.NUT_ALLERGY);
            assertNotNull(fat);
            assertFalse(fat.isNut(), "Nut Allergy diet should not allow nuts in fats");
        }
    }

    @Test
    public void testProteinFactoryPaleo() {
        ProteinFactory factory = ProteinFactory.getInstance();
        for (int i = 0; i < 10; i++) {
            Protein protein = factory.createRandomProtein(DietPlan.PALEO);
            assertNotNull(protein);
            assertFalse(protein.isTofu(), "Paleo diet should not allow Tofu");
        }
    }
}

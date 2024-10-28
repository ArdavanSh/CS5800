import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Set;
import food.*;

public class RandomnessTest {

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

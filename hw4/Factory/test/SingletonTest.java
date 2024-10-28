import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SingletonTest {

    @Test
    public void testSingletonCarbohydrateFactory() {
        CarbohydrateFactory instance1 = CarbohydrateFactory.getInstance();
        CarbohydrateFactory instance2 = CarbohydrateFactory.getInstance();
        assertSame(instance1, instance2, "CarbohydrateFactory instances are not the same");
    }

    @Test
    public void testSingletonProteinFactory() {
        ProteinFactory instance1 = ProteinFactory.getInstance();
        ProteinFactory instance2 = ProteinFactory.getInstance();
        assertSame(instance1, instance2, "ProteinFactory instances are not the same");
    }

    @Test
    public void testSingletonFatFactory() {
        FatFactory instance1 = FatFactory.getInstance();
        FatFactory instance2 = FatFactory.getInstance();
        assertSame(instance1, instance2, "FatFactory instances are not the same");
    }

    @Test
    public void testSingletonMacronutrientFactory() {
        MacronutrientFactory instance1 = MacronutrientFactory.getInstance();
        MacronutrientFactory instance2 = MacronutrientFactory.getInstance();
        assertSame(instance1, instance2, "MacronutrientFactory instances are not the same");
    }
}

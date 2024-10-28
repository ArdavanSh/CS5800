import java.util.*;
import java.util.stream.Collectors;
import food.*;

public class FatFactory {
    private static FatFactory instance;
    private FatFactory() {}
    public static synchronized FatFactory getInstance() {
        if (instance == null) {
            instance = new FatFactory();
        }
        return instance;
    }
    public Fat createRandomFat(DietPlan dietPlan) {
        List<Fat> options = new ArrayList<>();
        // Add all options
        options.add(new Avocado());
        options.add(new SourCream());
        options.add(new Tuna());
        options.add(new Peanuts());

        // Filter options based on diet plan
        options = options.stream()
                .filter(fat -> isAllowed(fat, dietPlan))
                .collect(Collectors.toList());

        if (options.isEmpty()) {
            return null; // No options available
        }

        // Randomly select one from the options
        Random rand = new Random();
        return options.get(rand.nextInt(options.size()));
    }

    private boolean isAllowed(Fat fat, DietPlan dietPlan) {
        switch(dietPlan) {
            case NO_RESTRICTION:
                return true;
            case PALEO:
                // No Dairy (Sour cream)
                if (fat.isDairy()) return false;
                return true;
            case VEGAN:
                // No Meat (Tuna), No Dairy (Sour cream)
                if (fat.isMeat()) return false;
                if (fat.isDairy()) return false;
                return true;
            case NUT_ALLERGY:
                // No Nuts (Peanuts)
                if (fat.isNut()) return false;
                return true;
            default:
                return true;
        }
    }
}

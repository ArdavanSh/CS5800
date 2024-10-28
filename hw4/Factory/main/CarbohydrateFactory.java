import food.*;
import java.util.*;
import java.util.stream.Collectors;

public class CarbohydrateFactory {
    private static CarbohydrateFactory instance;
    private CarbohydrateFactory() {}
    public static synchronized CarbohydrateFactory getInstance() {
        if (instance == null) {
            instance = new CarbohydrateFactory();
        }
        return instance;
    }
    public Carbohydrate createRandomCarbohydrate(DietPlan dietPlan) {
        List<Carbohydrate> options = new ArrayList<>();
        // Add all options
        options.add(new Cheese());
        options.add(new Bread());
        options.add(new Lentils());
        options.add(new Pistachio());

        // Filter options based on diet plan
        options = options.stream()
                .filter(carb -> isAllowed(carb, dietPlan))
                .collect(Collectors.toList());

        if (options.isEmpty()) {
            return null; // No options available
        }

        // Randomly select one from the options
        Random rand = new Random();
        return options.get(rand.nextInt(options.size()));
    }

    private boolean isAllowed(Carbohydrate carb, DietPlan dietPlan) {
        switch(dietPlan) {
            case NO_RESTRICTION:
                return true;
            case PALEO:
                // No Carbs except pistachio, No Dairy (Cheese)
                if (carb.isDairy()) return false;
                if (!carb.getName().equals("Pistachio")) return false;
                return true;
            case VEGAN:
                // No Dairy (Cheese)
                if (carb.isDairy()) return false;
                return true;
            case NUT_ALLERGY:
                // No Nuts (Pistachio)
                if (carb.isNut()) return false;
                return true;
            default:
                return true;
        }
    }
}

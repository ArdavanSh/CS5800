import java.util.*;
import java.util.stream.Collectors;
import food.*;

public class ProteinFactory {
    private static ProteinFactory instance;
    private ProteinFactory() {}
    public static synchronized ProteinFactory getInstance() {
        if (instance == null) {
            instance = new ProteinFactory();
        }
        return instance;
    }
    public Protein createRandomProtein(DietPlan dietPlan) {
        List<Protein> options = new ArrayList<>();
        // Add all options
        options.add(new Fish());
        options.add(new Chicken());
        options.add(new Beef());
        options.add(new Tofu());

        // Filter options based on diet plan
        options = options.stream()
                .filter(protein -> isAllowed(protein, dietPlan))
                .collect(Collectors.toList());

        if (options.isEmpty()) {
            return null; // No options available
        }

        // Randomly select one from the options
        Random rand = new Random();
        return options.get(rand.nextInt(options.size()));
    }

    private boolean isAllowed(Protein protein, DietPlan dietPlan) {
        switch(dietPlan) {
            case NO_RESTRICTION:
                return true;
            case PALEO:
                // No Tofu
                if (protein.isTofu()) return false;
                return true;
            case VEGAN:
                // No Meat (Fish, Chicken, Beef)
                if (protein.isMeat()) return false;
                return true;
            case NUT_ALLERGY:
                // No restrictions on proteins
                return true;
            default:
                return true;
        }
    }
}


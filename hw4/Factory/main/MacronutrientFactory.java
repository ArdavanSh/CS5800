public class MacronutrientFactory {
    private static MacronutrientFactory instance;
    private MacronutrientFactory() {}
    public static synchronized MacronutrientFactory getInstance() {
        if (instance == null) {
            instance = new MacronutrientFactory();
        }
        return instance;
    }
    public CarbohydrateFactory getCarbohydrateFactory() {
        return CarbohydrateFactory.getInstance();
    }
    public ProteinFactory getProteinFactory() {
        return ProteinFactory.getInstance();
    }
    public FatFactory getFatFactory() {
        return FatFactory.getInstance();
    }
}


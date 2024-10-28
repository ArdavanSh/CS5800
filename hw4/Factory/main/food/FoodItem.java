package food;

public abstract class FoodItem {
    public abstract String getName();
    public boolean isDairy() { return false; }
    public boolean isMeat() { return false; }
    public boolean isNut() { return false; }
    public boolean isTofu() { return false; }
}


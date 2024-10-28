package food;

public class Fish extends Protein {
    @Override
    public String getName() { return "Fish"; }
    @Override
    public boolean isMeat() { return true; }
}

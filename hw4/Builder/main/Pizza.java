import java.util.List;

public class Pizza {
    public enum Size { SMALL, MEDIUM, LARGE }

    private Size size;
    private List<String> toppings;

    public Pizza(Size size, List<String> toppings) {
        this.size = size;
        this.toppings = toppings;
    }

    public Size getSize() {
        return size;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public void eat() {
        System.out.println("Eating a " + size + " pizza with the following toppings: " + toppings);
    }
}


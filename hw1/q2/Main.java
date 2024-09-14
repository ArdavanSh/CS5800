//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Ship[] ships = new Ship[3];

        ships[0] = new Ship("ShipA", "1912");
        ships[1] = new CruiseShip("ShipB", "2009", 6780);
        ships[2] = new CargoShip("ShipC", "2006", 140000);

        for (Ship ship : ships) {
            ship.print();
        }

    }
}
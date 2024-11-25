import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class VendingMachineTest {

    private VendingMachine vm;

    @Before
    public void setUp() {
        vm = new VendingMachine();

        // Add snacks
        vm.addSnack(new Snack("Coke", 1.50, 5));
        vm.addSnack(new Snack("Pepsi", 1.50, 5));
        vm.addSnack(new Snack("Cheetos", 1.00, 5));
        vm.addSnack(new Snack("Doritos", 1.00, 5));
        vm.addSnack(new Snack("KitKat", 0.75, 5));
        vm.addSnack(new Snack("Snickers", 0.75, 1)); // Only 1 Snickers

        // Set up chain of responsibility
        SnackDispenseHandler cokeHandler = new CokeDispenseHandler();
        SnackDispenseHandler pepsiHandler = new PepsiDispenseHandler();
        SnackDispenseHandler cheetosHandler = new CheetosDispenseHandler();
        SnackDispenseHandler doritosHandler = new DoritosDispenseHandler();
        SnackDispenseHandler kitkatHandler = new KitKatDispenseHandler();
        SnackDispenseHandler snickersHandler = new SnickersDispenseHandler();

        cokeHandler.setNextHandler(pepsiHandler);
        pepsiHandler.setNextHandler(cheetosHandler);
        cheetosHandler.setNextHandler(doritosHandler);
        doritosHandler.setNextHandler(kitkatHandler);
        kitkatHandler.setNextHandler(snickersHandler);

        vm.setSnackDispenseHandler(cokeHandler);
    }

    @Test
    public void testPurchaseWithExactChange() {
        vm.selectSnack("Cheetos");
        vm.insertMoney(1.00);

        Snack cheetos = vm.getSnack("Cheetos");
        assertEquals(4, cheetos.getQuantity());

        assertEquals(0.0, vm.getInsertedMoney(), 0.001);

        assertNull(vm.getSelectedSnack());
    }

    @Test
    public void testPurchaseWithMoreThanEnoughMoney() {
        vm.selectSnack("KitKat");
        vm.insertMoney(1.00);

        Snack kitkat = vm.getSnack("KitKat");
        assertEquals(4, kitkat.getQuantity());

        assertEquals(0.0, vm.getInsertedMoney(), 0.001);

        assertNull(vm.getSelectedSnack());
    }

    @Test
    public void testPurchaseWithInsufficientMoney() {
        vm.selectSnack("Doritos");
        vm.insertMoney(0.50);

        Snack doritos = vm.getSnack("Doritos");
        assertEquals(5, doritos.getQuantity());

        assertEquals(0.50, vm.getInsertedMoney(), 0.001);

        vm.insertMoney(0.50);

        assertEquals(4, doritos.getQuantity());
        assertEquals(0.0, vm.getInsertedMoney(), 0.001);
        assertNull(vm.getSelectedSnack());
    }

    @Test
    public void testPurchaseOutOfStockSnack() {
        Snack snickers = vm.getSnack("Snickers");
        assertEquals(1, snickers.getQuantity());

        vm.selectSnack("Snickers");
        vm.insertMoney(0.75);

        assertEquals(0, snickers.getQuantity());

        vm.selectSnack("Snickers");
        vm.insertMoney(0.75);

        assertEquals(0, snickers.getQuantity());

        assertEquals(0.0, vm.getInsertedMoney(), 0.001);
        assertNull(vm.getSelectedSnack());
    }

    @Test
    public void testPurchaseNonExistentSnack() {
        vm.selectSnack("MarsBar");
        vm.insertMoney(1.00);

        assertEquals(0.0, vm.getInsertedMoney(), 0.001);
        assertNull(vm.getSelectedSnack());
    }

    @Test
    public void testSelectSnackWithoutInsertingMoney() {
        vm.selectSnack("Coke");

        assertEquals("Coke", vm.getSelectedSnack());
        assertEquals(0.0, vm.getInsertedMoney(), 0.001);

        vm.insertMoney(1.00);
        assertEquals(1.00, vm.getInsertedMoney(), 0.001);

        Snack coke = vm.getSnack("Coke");
        assertEquals(5, coke.getQuantity());

        vm.insertMoney(0.50);

        assertEquals(4, coke.getQuantity());
        assertEquals(0.0, vm.getInsertedMoney(), 0.001);
        assertNull(vm.getSelectedSnack());
    }
}

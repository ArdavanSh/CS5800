public class DispensingSnackState implements StateOfVendingMachine {
    private VendingMachine vendingMachine;

    public DispensingSnackState(VendingMachine vm) {
        this.vendingMachine = vm;
    }

    @Override
    public void selectSnack(String snackName) {
        System.out.println("Currently dispensing a snack. Please wait.");
    }

    @Override
    public void insertMoney(double amount) {
        System.out.println("Currently dispensing a snack. Please wait.");
    }

    @Override
    public void dispenseSnack() {
        SnackDispenseHandler handler = vendingMachine.getSnackDispenseHandler();
        handler.handle(vendingMachine.getSelectedSnack(), vendingMachine);

        vendingMachine.setState(vendingMachine.getIdleState());
        vendingMachine.resetTransaction();
    }
}

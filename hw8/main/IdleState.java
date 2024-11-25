public class IdleState implements StateOfVendingMachine {
    private VendingMachine vendingMachine;

    public IdleState(VendingMachine vm) {
        this.vendingMachine = vm;
    }

    @Override
    public void selectSnack(String snackName) {
        vendingMachine.setSelectedSnack(snackName);
        System.out.println("Snack " + snackName + " selected.");
        vendingMachine.setState(vendingMachine.getWaitingForMoneyState());
    }

    @Override
    public void insertMoney(double amount) {
        System.out.println("Please select a snack first.");
    }

    @Override
    public void dispenseSnack() {
        System.out.println("Please select a snack and insert money first.");
    }
}

public class WaitingForMoneyState implements StateOfVendingMachine {
    private VendingMachine vendingMachine;

    public WaitingForMoneyState(VendingMachine vm) {
        this.vendingMachine = vm;
    }

    @Override
    public void selectSnack(String snackName) {
        System.out.println("Snack already selected. Please insert money.");
    }

    @Override
    public void insertMoney(double amount) {
        vendingMachine.addMoney(amount);
        System.out.println("Inserted $" + amount);
        double totalInserted = vendingMachine.getInsertedMoney();
        double snackPrice = vendingMachine.getSelectedSnackPrice();
        if (totalInserted >= snackPrice) {
            vendingMachine.setState(vendingMachine.getDispensingSnackState());
            vendingMachine.dispenseSnack();
        } else {
            System.out.println("Please insert additional $" + (snackPrice - totalInserted));
        }
    }

    @Override
    public void dispenseSnack() {
        System.out.println("Not enough money inserted.");
    }
}

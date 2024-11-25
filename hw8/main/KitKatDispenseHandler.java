public class KitKatDispenseHandler extends SnackDispenseHandler {
    @Override
    public void handle(String snackName, VendingMachine vendingMachine) {
        if (snackName.equalsIgnoreCase("KitKat")) {
            Snack snack = vendingMachine.getSnack("KitKat");
            if (snack != null && snack.getQuantity() > 0) {
                snack.reduceQuantity();
                double change = vendingMachine.getInsertedMoney() - snack.getPrice();
                System.out.println("Dispensing KitKat. Change: $" + change);
            } else {
                System.out.println("KitKat is not available.");
                System.out.println("Returning inserted money: $" + vendingMachine.getInsertedMoney());
            }
        } else if (nextHandler != null) {
            nextHandler.handle(snackName, vendingMachine);
        } else {
            System.out.println("Snack not found in vending machine.");
            System.out.println("Returning inserted money: $" + vendingMachine.getInsertedMoney());
        }
    }
}

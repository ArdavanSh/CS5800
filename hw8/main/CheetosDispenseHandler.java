public class CheetosDispenseHandler extends SnackDispenseHandler {
    @Override
    public void handle(String snackName, VendingMachine vendingMachine) {
        if (snackName.equalsIgnoreCase("Cheetos")) {
            Snack snack = vendingMachine.getSnack("Cheetos");
            if (snack != null && snack.getQuantity() > 0) {
                snack.reduceQuantity();
                double change = vendingMachine.getInsertedMoney() - snack.getPrice();
                System.out.println("Dispensing Cheetos. Change: $" + change);
            } else {
                System.out.println("Cheetos is not available.");
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

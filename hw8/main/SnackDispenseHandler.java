public abstract class SnackDispenseHandler {
    protected SnackDispenseHandler nextHandler;

    public void setNextHandler(SnackDispenseHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handle(String snackName, VendingMachine vendingMachine);
}

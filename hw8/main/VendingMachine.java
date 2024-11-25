import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private StateOfVendingMachine idleState;
    private StateOfVendingMachine waitingForMoneyState;
    private StateOfVendingMachine dispensingSnackState;

    private StateOfVendingMachine currentState;

    private SnackDispenseHandler snackDispenseHandler;

    private Map<String, Snack> snacks;

    private String selectedSnackName;
    private double insertedMoney;

    public VendingMachine() {
        idleState = new IdleState(this);
        waitingForMoneyState = new WaitingForMoneyState(this);
        dispensingSnackState = new DispensingSnackState(this);

        currentState = idleState;

        snacks = new HashMap<>();
    }

    public void setState(StateOfVendingMachine state) {
        this.currentState = state;
    }

    public StateOfVendingMachine getIdleState() {
        return idleState;
    }

    public StateOfVendingMachine getWaitingForMoneyState() {
        return waitingForMoneyState;
    }

    public StateOfVendingMachine getDispensingSnackState() {
        return dispensingSnackState;
    }

    public void setSnackDispenseHandler(SnackDispenseHandler handler) {
        this.snackDispenseHandler = handler;
    }

    public SnackDispenseHandler getSnackDispenseHandler() {
        return snackDispenseHandler;
    }

    public void addSnack(Snack snack) {
        snacks.put(snack.getName(), snack);
    }

    public Snack getSnack(String name) {
        return snacks.get(name);
    }

    public void selectSnack(String snackName) {
        currentState.selectSnack(snackName);
    }

    public void insertMoney(double amount) {
        currentState.insertMoney(amount);
    }

    public void dispenseSnack() {
        currentState.dispenseSnack();
    }

    public void setSelectedSnack(String snackName) {
        this.selectedSnackName = snackName;
    }

    public String getSelectedSnack() {
        return selectedSnackName;
    }

    public double getSelectedSnackPrice() {
        Snack snack = getSnack(selectedSnackName);
        if (snack != null) {
            return snack.getPrice();
        } else {
            return 0;
        }
    }

    public void addMoney(double amount) {
        this.insertedMoney += amount;
    }

    public double getInsertedMoney() {
        return insertedMoney;
    }

    public void resetTransaction() {
        selectedSnackName = null;
        insertedMoney = 0;
    }
}

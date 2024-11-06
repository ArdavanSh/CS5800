public class CustomerLoyalty {
    public enum LoyaltyStatus {
        REGULAR,
        SILVER,
        GOLD,
        PLATINUM
    }

    private LoyaltyStatus status;

    public CustomerLoyalty(LoyaltyStatus status) {
        this.status = status;
    }

    public double applyDiscount(double totalCost) {
        double discount = 0.0;
        switch (status) {
            case SILVER:
                discount = 0.05; // 5% discount
                break;
            case GOLD:
                discount = 0.10; // 10% discount
                break;
            case PLATINUM:
                discount = 0.15; // 15% discount
                break;
            default:
                discount = 0.0; // No discount
                break;
        }
        return totalCost * (1 - discount);
    }

    public LoyaltyStatus getStatus() {
        return status;
    }
}

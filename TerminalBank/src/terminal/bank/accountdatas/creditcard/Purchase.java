package terminal.bank.accountdatas.creditcard;

public class Purchase implements Comparable<Purchase>{
    private String description;
    private double purchaseValue;

    public Purchase(String description, double purchaseValue) {
        this.description = description;
        this.purchaseValue = purchaseValue;
    }

    public String getDescription() {
        return description;
    }

    public double getPurchaseValue() {
        return purchaseValue;
    }


    @Override
    public String toString() {
        return "Purchase:\n" +
                "Description: " + description + '\n' +
                "Purchase Value: " + purchaseValue;
    }

    @Override
    public int compareTo(Purchase otherPurchase) {
        return Double.valueOf(this.purchaseValue).compareTo(Double.valueOf(otherPurchase.purchaseValue));
    }
}

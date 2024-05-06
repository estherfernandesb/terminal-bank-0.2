package terminal.bank.accountdatas.creditcard;


import java.util.ArrayList;
import java.util.List;

    public class CreditCard {

        private double limit;
        private List<Purchase> purchases;

        public List<Purchase> getPurchases() {
            return purchases;
        }

        public CreditCard(double limit) {
            this.limit = limit;
            this.purchases = new ArrayList<>();
        }

        public double getLimit() {
            return limit;
        }

        public double getValue() {
            return limit - getTotalPurchaseAmount();
        }

        private double getTotalPurchaseAmount() {
            double total = 0;
            for (Purchase purchase : purchases) {
                total += purchase.getPurchaseValue();
            }
            return total;
        }

        public boolean buying(Purchase purchase) {
            if (purchase.getPurchaseValue() <= getValue()) {
                purchases.add(purchase);
                return true;
            } else {
                return false;
            }
        }
    }



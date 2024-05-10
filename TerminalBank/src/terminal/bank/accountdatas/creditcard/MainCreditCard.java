package terminal.bank.accountdatas.creditcard;

import java.util.Collections;
import java.util.Scanner;

public class MainCreditCard {
    public static void main(String[] args) {
        mainMenu(); // Chamando o método para exibir o menu
    }

    public static void mainMenu() {
        Scanner reading = new Scanner(System.in);
        CreditCard card = new CreditCard(1000); // Definindo um limite inicial de 1000 (pode ser ajustado conforme necessário)

        String menuCard = """
                        Welcome to Credit Card Operations,
                        Here you can buy anything you want!
                        However, only what fits in your pockets!

                        Enter 1 to start your purchases or 0 to exit.""";

        System.out.println(menuCard);
        int choice = reading.nextInt();

        switch (choice) {
            case 1:
                purchaseOperations(card, reading); // Iniciar as operações de compra
                break;
            case 0:
                System.out.println("Exiting Credit Card Operations.");
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    public static void purchaseOperations(CreditCard card, Scanner reading) {
        double totalPurchaseAmount = 0;
        double remainingLimit = card.getLimit();

        while (true) {
            System.out.println("Enter purchase description: ");
            String description = reading.next();

            System.out.println("Enter purchase value: ");
            double purchaseValue = reading.nextDouble();

            Purchase purchase = new Purchase(description, purchaseValue);
            boolean purchaseMade = card.buying(purchase);

            if (purchaseMade) {
                totalPurchaseAmount += purchaseValue;
                remainingLimit -= purchaseValue;
                System.out.println("Purchase successful!");
            } else {
                System.out.println("Purchase failed! Insufficient balance.");
            }

            System.out.println("Do you want to make another purchase? (1 for Yes, 0 for No)");
            int continueChoice = reading.nextInt();

            if (continueChoice == 0) {
                break; // Sair do loop se o usuário não quiser fazer outra compra
            }
        }

        // Exibir o saldo final e o limite restante após as compras
        System.out.println("***********************");
        System.out.println("PURCHASES MADE:\n");

        Collections.sort(card.getPurchases());
        for (Purchase purchase : card.getPurchases()) {
            System.out.println(purchase.getDescription() + " - " + "R$ " + purchase.getPurchaseValue());
        }

        System.out.println("***********************");
        remainingLimit = card.getLimit() - totalPurchaseAmount;
        System.out.println("Card Balance: " + card.getValue());
        System.out.println("Remaining Limit: " + remainingLimit);

        // Após exibir os detalhes, retornar ao menu principal
        mainMenu();
    }
}

package terminal.bank.accountdatas.main;
import terminal.bank.accountdatas.operationsdatas.Datas;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        System.out.println("****************************************");
        System.out.println("*************Terminal Bank**************");
        System.out.println("****************************************");

        System.out.println("""
                Hello and Welcome to Terminal Bank, here you can manage your account.
                Deposit your money safely and conscientiously!
                Terminal Bank take care your money!
                """);

        Datas myDatas = new Datas();
        Scanner reading = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = reading.nextLine();
        myDatas.setName(name);

        System.out.println("Enter you e-mail: ");
        String email = reading.nextLine();
        myDatas.setEmail(email);

        System.out.println("Please, enter your balance: ");
        double balance = reading.nextDouble();
        myDatas.setBalance(balance);

        //Verificando se o seu saldo é suficiente para abrir uma poupança ou não
        if (balance >= 1000) {
            myDatas.setAccountType(true); // Tem uma poupança
            System.out.println("Congrats! Your balance is enough to have a savings account!");
        } else {
            myDatas.setAccountType(false); // Não tem uma poupança
            System.out.println("Your balance isn't enough to open a savings account.");
        }
        myDatas.displaysProcess();

    }
}
package terminal.bank.accountdatas.main;
import terminal.bank.accountdatas.operationsdatas.Datas;
import terminal.bank.accountdatas.operationsdatas.DatasRercording;
import terminal.bank.accountdatas.operationsdatas.SaveDatas;

import java.io.IOException;
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

        SaveDatas saveDatas = new SaveDatas();
        Datas myDatas = new Datas();
        Scanner reading = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = reading.nextLine();
        myDatas.setName(name);

        System.out.println("Enter you e-mail: ");
        String email = reading.nextLine();
        myDatas.setEmail(email);

        DatasRercording datasRecording = new DatasRercording(myDatas.getName(), myDatas.getEmail(), myDatas.isAccountType(), myDatas.getBalance());

        // Para criar um arquivo JSON e salvar seus dados lá
        try {
            saveDatas.jsonFiles(datasRecording);
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while saving data: " + e.getMessage());
        }

        System.out.println("Please, enter your balance: ");
        double balance = reading.nextDouble();

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
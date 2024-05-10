package terminal.bank.accountdatas.operationsdatas;

import terminal.bank.accountdatas.creditcard.CreditCard;

//Classe de verificação das operações
public class Operations {
        /*  1- Check Balance
            2- Receive Value
            3- Value Transfer
            4-Exit
         */

    private int process = 0;

    public int getProcess() {
        return process;
    }

    public void setProcess(int process) {
        this.process = process;
    }
}

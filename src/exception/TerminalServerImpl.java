package exception;

/**
 * Created by Valentina on 25.09.2016.
 */
public class TerminalServerImpl {
    private final int pin;
    private int balance;

    public TerminalServerImpl(int pin, int balance) {
        this.pin = pin;
        this.balance = balance;
    }

    public int getPin() {
        return pin;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void deposit(int sum){
        balance+=sum;
    }
    public void withdraw(int sum) {
        try {
            if (sum <= balance && sum > 0) {
                balance = balance - sum;
            } else
                throw new InvalidBalanceException();
        }
    catch(InvalidBalanceException e){
        System.out.println("Баланс: "+getBalance());
    }

    }

}

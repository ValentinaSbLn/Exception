package exception;

/**
 * Created by Valentina on 25.09.2016.
 */
public class TerminalServerImpl implements TerminalServer {
    private final int pin;
    private int balance;
    private int countConnect;

    public void setCountConnect(int countConnect) {
        this.countConnect=countConnect;
    }

    public TerminalServerImpl(int pin, int balance) {
        this.pin = pin;
        this.balance = balance;
    }

    @Override
    public int getPin() {
        return pin;
    }

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public void deposit(int sum) {
        balance += sum;
    }

    @Override
    public void withdraw(int sum) {
        try {
            if (sum <= balance && sum > 0) {
                balance = balance - sum;
            } else
                throw new InvalidBalanceException();
        } catch (InvalidBalanceException e) {
            System.out.println("Баланс: " + getBalance());
        }

    }

    @Override
    public void countConnect() throws ServerWorkException {
        countConnect++;
        if (countConnect > 5)
            throw new ServerWorkException(this);
    }

}

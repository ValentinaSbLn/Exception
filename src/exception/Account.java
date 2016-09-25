package exception;

/**
 * Created by Valentina on 25.09.2016.
 */
public class Account {
    private String customer;
    private int pin;
    private double balance;

    public Account(String customer, int pin, double balance) {
        this.customer = customer;
        this.pin = pin;
        this.balance = balance;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

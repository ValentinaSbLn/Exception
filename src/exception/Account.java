package exception;

public class Account {
    private String customer;


    private final int numAccount;
    private int pin;
    private int balance;

    public Account(String customer, int numAccount, int pin, int balance) {
        this.customer = customer;
        this.numAccount = numAccount;
        this.pin = pin;
        this.balance = balance;
    }

    public Account(int numAccount, int pin, int balance) {
        this.numAccount = numAccount;
        this.pin = pin;
        this.balance = balance;
    }

    public int getNumAccount() {
        return numAccount;
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

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}

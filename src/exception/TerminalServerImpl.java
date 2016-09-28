package exception;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valentina on 25.09.2016.
 */
public class TerminalServerImpl implements TerminalServer {
//    private final int pin;
//    private int balance;
    private int countConnect;
    private List<Account> accounts;

    public void setCountConnect(int countConnect) {
        this.countConnect=countConnect;
    }

//    public TerminalServerImpl(int pin, int balance) {
//        this.pin = pin;
//        this.balance = balance;
//    }
public TerminalServerImpl() {
    accounts= new ArrayList<>();
    accounts.add(new Account(1111, 1111, 100));
    accounts.add(new Account(2222, 2222, 1000));
    accounts.add(new Account(3333, 3333, 2000));
    accounts.add(new Account(4444, 4444, 3000));
}

    @Override
    public int getPin(int num) {
        int pin=0;
        try {
             pin=accounts.get(getnumAccount(num)).getPin();
        } catch (InvalidNumAccount invalidNumAccount) {
            invalidNumAccount.printStackTrace();
        }
        return pin;
    }
private int getnumAccount(int num) throws InvalidNumAccount{
    int k=-1;
   for (int i=0; i<accounts.size(); i++){
       if(num==accounts.get(i).getNumAccount())
           k=i;
    }
    if (k==-1)
        new InvalidNumAccount();
    return k;
}

    @Override
    public int getBalance(int num) {
        int balance=0;
        try {
            balance= accounts.get(getnumAccount(num)).getBalance();
        } catch (InvalidNumAccount invalidNumAccount) {
            invalidNumAccount.printStackTrace();
        }
       return balance;
    }

    @Override
    public void setBalance(int num, int balance) {

        try {
            accounts.get(getnumAccount(num)).setBalance(balance);
        } catch (InvalidNumAccount invalidNumAccount) {
            invalidNumAccount.printStackTrace();
        }
    }

    @Override
    public void deposit(int num, int sum) {
        setBalance(num, getBalance(num)+sum);
//        balance += sum;
    }

    @Override
    public void withdraw(int num, int sum) {
        try {
            if (sum <= getBalance(num) && sum > 0) {
                setBalance(num, getBalance(num)-sum);
            } else
                throw new InvalidBalanceException();
        } catch (InvalidBalanceException e) {
            System.out.println("Баланс: " + getBalance(num));
        }

    }

    @Override
    public void countConnect() throws ServerWorkException {
        countConnect++;
        if (countConnect > 5)
            throw new ServerWorkException(this);
    }

}

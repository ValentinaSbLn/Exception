package exception;

public interface Terminal {
    boolean pin=false;

    public void printBalance() throws InvalidPinException;
    public void takeMoney() throws InvalidPinException;
    public void putMoney() throws InvalidPinException;
    public boolean enterPIN(int pin);


}

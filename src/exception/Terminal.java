package exception;

public interface Terminal {
    /**
     * Запрос баланса
     */
    public void printBalance() throws InvalidPinException;

    /**
     * Запрос к серверу на снятие наличных
     */
    public void takeMoney() throws InvalidPinException;

    /**
     * Запрос к серверу на пополнение счета
     */
    public void putMoney() throws InvalidPinException;

}

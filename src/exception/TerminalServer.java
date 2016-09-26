package exception;

/**
 * Created by Valentina on 25.09.2016.
 */
public interface TerminalServer {

    /**
     * Метод возвращает PIN пользователя
     * @return PIN
     */
    public int getPin();
    /**
     * Метод возвращает количество денег на счету пользователя
     * @return balance
     */
    public int getBalance();

    /**
     * @param balance
     */
    public void setBalance(int balance);

    /**
     * Метод, позволяющий зачислить деньги на счет
     * @param sum - вносимая сумма на счет
     */
    public void deposit(int sum);

    /**
     * Метод, позволяющий снять деньги со счет
     * @param sum - вносимая сумма на счет
     * @exception InvalidBalanceException() - баланс меньше запрашиваемой суммы
     */
    public void withdraw(int sum);

    /**
     * Метод, определяющий количество обращений к серверу и в случае определенного количества выкидывающего ошибку о выполнении работ
     * @exception InvalidBalanceException() - баланс меньше запрашиваемой суммы
     */
    public void countConnect() throws ServerWorkException;

    public void setCountConnect(int countConnect);
}

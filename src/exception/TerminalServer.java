package exception;

/**
 * Created by Valentina on 25.09.2016.
 */
public interface TerminalServer {

    /**
     * Метод возвращает PIN пользователя
     * @param num - принимает номер счета
     * @return PIN
     */
    public int getPin(int num);
    /**
     * Метод возвращает количество денег на счету пользователя
     * @param num - принимает номер счета
     * @return balance
     */
    public int getBalance(int num);

    /**
     * @param num - принимает номер счета
     * @param balance
     */
    public void setBalance(int num, int balance);

    /**
     * Метод, позволяющий зачислить деньги на счет
     * @param num - принимает номер счета
     * @param sum - вносимая сумма на счет
     */
    public void deposit(int num, int sum);

    /**
     * Метод, позволяющий снять деньги со счет
     * @param num - принимает номер счета
     * @param sum - вносимая сумма на счет
     * @exception InvalidBalanceException() - баланс меньше запрашиваемой суммы
     */
    public void withdraw(int num, int sum);

    /**
     * Метод, определяющий количество обращений к серверу и в случае определенного количества выкидывающего ошибку о выполнении работ
     *  @exception ServerWorkException() - превышен лимит операций
     */
    public void countConnect() throws ServerWorkException;

    public void setCountConnect(int countConnect);
}

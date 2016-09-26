package exception;

/**
 * Created by Valentina on 25.09.2016.
 */
/**
 * Исключение выбрасывается, когда на счету меньше запрашиваемой суммы
 */
public class InvalidBalanceException extends Exception {
    private static final long serialVersionUID = -2586424477138775105L;

    InvalidBalanceException() {
        System.out.println("Баланс меньше запрашиваемой суммы");
    }

    public InvalidBalanceException(String message, Throwable cause) {
        super(cause);
        System.out.println("Баланс меньше запрашиваемой суммы");
    }
}

package exception;

/**
 * Created by Valentina on 25.09.2016.
 */
public class InvalidBalanceException extends Exception{
    InvalidBalanceException(){
        System.out.println("Баланс меньше запрашиваемой суммы");
    }
}

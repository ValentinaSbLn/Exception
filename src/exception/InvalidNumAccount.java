package exception;

/**
 * Created by Valentina on 28.09.2016.
 */
public class InvalidNumAccount extends Exception {
    InvalidNumAccount(){
        System.out.println("Введен неверный номер счета");
    }
}

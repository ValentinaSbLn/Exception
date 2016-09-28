package exception;

/**
 * Created by Valentina on 25.09.2016.
 */
/**
 * Исключение выбрасывается, когда пользователь обращается к системе при введенном неверном пин-коде
 */
public class InvalidPinException extends Exception{
    private static final long serialVersionUID = -2586424477138885105L;

    InvalidPinException(String s){
        System.out.println(s+"Введен неверный PIN" );
    }
    InvalidPinException(){
        new InvalidPinException("");
    }
}

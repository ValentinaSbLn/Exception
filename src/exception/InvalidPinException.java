package exception;

/**
 * Created by Valentina on 25.09.2016.
 */
public class InvalidPinException extends Exception{
    InvalidPinException(String s){
        System.out.println(s+" Введен неверный PIN" );
    }
}

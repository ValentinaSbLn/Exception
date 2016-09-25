package exception;

/**
 * Created by Valentina on 25.09.2016.
 */
public class AccountIsLockedException extends Exception{
    AccountIsLockedException(){
        System.out.println("Вы неправильно ввели PIN три раза. Терминал будет заблокирован на 5 секунд, после чего можете повторить ввод PIN");
    }
}

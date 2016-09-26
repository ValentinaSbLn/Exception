package exception;

/**
 * Created by Valentina on 25.09.2016.
 */

import java.util.Timer;
import java.util.TimerTask;

/**
 * Исключение выбрасывается, когда пользователь три раза неправильно вводит ПИН код
 */
public class AccountIsLockedException extends Exception {
    private static final long serialVersionUID = -2586414477138775105L;

    AccountIsLockedException() {
        System.out.println("Вы неправильно ввели PIN три раза. Терминал будет заблокирован на 5 секунд, после чего можете повторить ввод PIN");
        final Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            int i = 5;

            public void run() {
                System.out.println("Повторная попытка возможна через: " + i--);
                if (i < 0)
                    timer.cancel();
            }
        }, 0, 1000);
    }

    AccountIsLockedException(Throwable cause) {
        super(cause);
        new AccountIsLockedException();
    }
}

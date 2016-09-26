package exception;

/**
 * Created by Valentina on 26.09.2016.
 */
/**
 * Исключение выдается, когда превышен лимил операций на сервере и ведутся работы
 */

public class ServerWorkException extends Exception {
    private static final long serialVersionUID = -2586414479685775105L;

    ServerWorkException(TerminalServerImpl server) {
        System.out.println("На сервере ведутся работы. Подождите");
        server.setCountConnect(1);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }

}

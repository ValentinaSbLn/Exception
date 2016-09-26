package exception;

import java.util.Scanner;

/**
 * Created by Valentina on 25.09.2016.
 */
public class PinValidator {
    private int pin;
    private  boolean enterPin= false;
    PinValidator(int pin){
        this.pin=pin;
    }

    public boolean validPin() throws AccountIsLockedException {
        int pin;
        int countEnterPin = 1;
        do {
            if (countEnterPin <= 3) {
                pin = enterPin();
                if (this.pin == pin) {
                    enterPin = true;
                } else {
                    System.out.println("PIN введен неверно. У вас осталось " + (3 - countEnterPin) + " попытки(а) из 3");
                    countEnterPin++;
                }
            } else
                throw new AccountIsLockedException();
        } while (!enterPin);
        return enterPin;
    }

    public int enterPin() {
        int pin;
        try {
            System.out.println("Введите PIN");
            Scanner in = new Scanner(System.in);
            String pinStr = in.nextLine();
            pin = Integer.parseInt(pinStr);

        } catch (NumberFormatException e) {
            System.out.println("Неверный формат ввода");
            return 0;
        }
        return pin;

    }

    public boolean getEnterPin() {
        return this.enterPin;
    }
}

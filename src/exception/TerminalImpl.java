package exception;

import java.util.Scanner;

/**
 * Created by Valentina on 25.09.2016.
 */
class TerminalImpl implements Terminal{
    private final TerminalServerImpl server;
    private final PinValidator pinValidator;

    public TerminalImpl(TerminalServerImpl server, PinValidator pinValidator) {
        this.server=server;
        this.pinValidator = pinValidator;
    }

    @Override
    public void printBalance() {
        try {
            if (!pinValidator.getEnterPin()) throw new InvalidPinException("Печать счета невозможна.");
            System.out.println(server.getBalance());

        } catch (InvalidPinException e) {
            System.out.println("Попробуйте ввести PIN заново");
        }
    }

    @Override
    public void takeMoney() {
        int withdraw;
        try {
            if (!pinValidator.getEnterPin()) throw new InvalidPinException("Внесение средств невозможно.");
            withdraw = enterMoney();
            if (withdraw >= 0) {
                if (withdraw % 10 == 0) {
                    server.withdraw(withdraw);
                } else
                    System.out.println("На счет можно класть суммы только кратные 100");

            } else
                System.out.println("Вы ввели отрицательное число");
        } catch (InvalidPinException e) {
            System.out.println("Попробуйте ввести PIN заново");
        }

    }

    @Override
    public void putMoney() {
        int deposit;
        try {
            if (!pinValidator.getEnterPin()) throw new InvalidPinException("Внесение средств невозможно.");
            deposit = enterMoney();
            if (deposit >= 0) {
                if (deposit % 10 == 0) {
                    server.deposit(deposit);
                } else
                    System.out.println("На счет можно класть суммы только кратные 100");

            } else
                System.out.println("Вы ввели отрицательное число");
        } catch (InvalidPinException e) {
            System.out.println("Попробуйте ввести PIN заново");
        }
    }

    @Override
    public boolean enterPIN(int pin) {
        return false;
    }

    public boolean run()  {

        try {
            pinValidator.validPin();
        } catch (AccountIsLockedException e) {
           return false;
        }
         return true;
    }
    public int enterMoney() {
        int money;
        try {
            System.out.println("Введите сумму");
            Scanner in = new Scanner(System.in);
            String pinStr = in.nextLine();

            money = Integer.parseInt(pinStr);
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат ввода");
            return 0;
        }
        return money;

    }

//    public static void main(String[] args)  {
//        TerminalImpl o=new TerminalImpl(new PinValidator());
//      //  o.run();
//        o.printBalance();
//    }

}

package exception;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Created by Valentina on 25.09.2016.
 */
class TerminalImpl implements Terminal {
    private final TerminalServerImpl server;
    private final PinValidator pinValidator;
    private static Logger log = Logger.getLogger(TerminalImpl.class.getName());

    public TerminalImpl(TerminalServerImpl server, PinValidator pinValidator) {
        this.server = server;
        this.pinValidator = pinValidator;
        try {
            LogManager.getLogManager().readConfiguration(
                    TerminalImpl.class.getResourceAsStream("/logging.properties"));

        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());

        }
    }

    /**
     * Запрос баланса
     */
    @Override
    public void printBalance() {

        try {
            server.countConnect();
            if (!pinValidator.getEnterPin()) throw new InvalidPinException("Печать счета невозможна.");
            System.out.println(server.getBalance());

        } catch (InvalidPinException e) {
            log.log(Level.INFO, "InvalidPinException");
        } catch (ServerWorkException e) {
            log.log(Level.INFO, "ServerWorkException");

        }
    }

    /**
     * Запрос к серверу на снятие наличных
     */
    @Override
    public void takeMoney() {
        int withdraw;

        try {
            server.countConnect();
            if (!pinValidator.getEnterPin()) throw new InvalidPinException("Внесение средств невозможно.");
            withdraw = enterMoney();
            if (withdraw >= 0) {
                if (withdraw % 10 == 0) {
                    server.withdraw(withdraw);
                } else
                    System.out.println("ERROR: Со счета можно снимать только суммы кратные 100");


            } else
                System.out.println("ERROR: Вы ввели отрицательное число");
        } catch (InvalidPinException e) {
            log.log(Level.INFO, "InvalidPinException");

        } catch (ServerWorkException e) {
            log.log(Level.INFO, "ServerWorkException");

        }

    }

    /**
     * Запрос к серверу на пополнение счета
     */
    @Override
    public void putMoney() {
        int deposit;

        try {
            server.countConnect();
            if (!pinValidator.getEnterPin()) throw new InvalidPinException("Внесение средств невозможно.");
            deposit = enterMoney();
            if (deposit >= 0) {
                if (deposit % 10 == 0) {
                    server.deposit(deposit);
                } else
                    System.out.println("ERROR: На счет можно класть суммы только кратные 100");

            } else
                System.out.println("ERROR: Вы ввели отрицательное число");
        } catch (InvalidPinException e) {
            log.log(Level.INFO, "InvalidPinException");
        } catch (ServerWorkException e) {
            log.log(Level.INFO, "ServerWorkException");
        }
    }

    public boolean run() {

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
}

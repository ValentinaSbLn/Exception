package exception;

import java.util.Scanner;

/**
 * Created by Valentina on 25.09.2016.
 */
public class TerminalInterface {


    public static void main(String[] args) {
        TerminalServerImpl server = new TerminalServerImpl(1245, 20000);
        PinValidator pinValidator= new PinValidator(server.getPin());
        TerminalImpl terminal = new TerminalImpl(server,pinValidator );

        System.out.println("Для начала работы необходимо ввести PIN");
        String job="y"; boolean b;
        do {
            b=terminal.run();
            if (!b){
            System.out.println("Для прекращения работы нажмите \"n\"");
            Scanner in = new Scanner(System.in);
            job=in.nextLine();
            }
        }while(!job.equals("n")&&!b);
        if (job.equals("n")) System.exit(0);

        System.out.println("Терминал приветствует вас");
        String select="n";
       do {
            System.out.println("Выберите действие:\n0- Выход \n1- Запрос баланса \n2- пополнить баланс \n3- снять наличные ");
            Scanner in = new Scanner(System.in);
            select=in.nextLine();
            switch (select){
                case "0":
                    System.out.println("До свидания");
                    System.exit(0);
                case "1":
                    terminal.printBalance();
                    break;
                case "2":
                    terminal.putMoney();
                    break;
                case "3":
                    terminal.takeMoney();
                    break;
                default:
                    System.out.println("введен неверный символ");
            }

        }while (!select.equals("0"));


    }
}

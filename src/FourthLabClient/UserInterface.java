package FourthLabClient;

import java.util.Scanner;

public class UserInterface
{
    private final WorkWithServer _server;
    private final Scanner in;
    public UserInterface()
    {
        _server = new WorkWithServer();
        in = new Scanner(System.in);
    }
    public UserInterface(String[] args)
    {
        int lengthPacket = Integer.parseInt(args[0]);
        String host = args[1];
        int port = Integer.parseInt(args[2]);

        _server = new WorkWithServer(lengthPacket, host, port);
        in = new Scanner(System.in);
    }

    private void Menu()
    {
        System.out.println("Основной функционал системы:");
        System.out.println("1 - Отправка сообщения и ожидание ответа");
        System.out.println("12 - Отправка сообщения без ожидания");
        System.out.println("2 - ожидание ответа от сервера");
        System.out.println("3 - Завершение работы");
        System.out.println("0 - Вывод меню");
    }

    private int InputFunc()
    {
        System.out.print("Введите команду: ");
        String input = in.nextLine();
        try
        {
            return Integer.parseInt(input);
        }
        catch (NumberFormatException e)
        {
            return -1;
        }
    }

    public void Start()
    {
        boolean infiCycle = true;
        String message;

        Menu();
        while(infiCycle)
        {
            var user_choise = InputFunc();

            switch (user_choise)
            {
                case 0:
                    Menu(); break;
                case 1:
                    System.out.print("Введите текст: ");
                    message = in.nextLine();
                    _server.SendAndGet(message); break;
                case 12:
                    System.out.print("Введите текст: ");
                    message = in.nextLine();
                    _server.SendMessage(message); break;
                case 2:
                    _server.AwaitMessage();
                case 3:
                    infiCycle = false;
                    _server.EndWork();
                    break;

                default:
                    System.out.println("Введена неверная команда");
            }
        }
    }
}

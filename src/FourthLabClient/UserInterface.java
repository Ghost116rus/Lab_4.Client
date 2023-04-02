package FourthLabClient;

import java.util.Scanner;

public class UserInterface
{
    private final WorkWithServer _server;
    private final Scanner in;
    public UserInterface()
    {
        in = new Scanner(System.in);

        System.out.println("default settings: \"localhost\" 2345");

        int lengthPacket = 60;
        System.out.print("Enter the address: ");
        String host = in.nextLine();
        System.out.print("Enter the port: ");
        int port = in.nextInt();
        in.nextLine();

        _server = new WorkWithServer(lengthPacket, host, port);
    }

    private void Menu()
    {
        System.out.println("The main functionality of the system:");
        System.out.println("1 - Sending a message and waiting for a response");
        System.out.println("2 - Additional commands");
        System.out.println("3 - Shutdown");
        System.out.println("0 - Menu output");
    }

    private void AdditionalCommands()
    {
        System.out.println("Additional system functionality:");
        System.out.println("12 - Sending a message without waiting");;
        System.out.println("22 - waiting for a response from the server");
        System.out.println("0 - Menu output");
    }


    private int InputFunc()
    {
        System.out.print("Enter the command: ");
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
                case 2:
                    AdditionalCommands(); break;
                case 1:
                    System.out.print("Enter the text: ");
                    message = in.nextLine();
                    _server.SendAndGet(message); break;
                case 12:
                    System.out.print("Enter the text: ");
                    message = in.nextLine();
                    _server.SendMessage(message); break;
                case 22:
                    _server.AwaitMessage();
                case 3:
                    infiCycle = false;
                    _server.EndWork();
                    break;

                default:
                    System.out.println("Invalid command");
            }
        }
    }
}

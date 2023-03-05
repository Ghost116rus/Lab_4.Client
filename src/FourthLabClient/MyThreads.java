package FourthLabClient;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Objects;
import java.util.Scanner;

class Await implements Runnable
{
    private final Scanner in;
    public String result;

    Await() {
        in = new Scanner(System.in);
    }

    @Override
    public void run() {
        result = "";
        while(true)
        {
            try
            {
                Thread.sleep(3000);
                System.out.println("Для отказа ждать сообщение нажмите 1: ");
                String input = in.nextLine();
                if(Objects.equals(input, "1"))
                {
                    result = "Пользователь отказался ждать сообщение ";
                    break;
                }
            }
            catch(InterruptedException e){
                System.out.println("Thread has been interrupted");
            }

        }
    }
}

class RecieveMessage implements Runnable
{
    private final int _lengthPacket;
    private DatagramSocket _socket;

    public String result;

    RecieveMessage(int lengthPacket,DatagramSocket socket) {
        _lengthPacket = lengthPacket;

        _socket = socket;
    }

    @Override
    public void run() {
        result = "";
        try
        {
            byte[] data2;
            data2 = new byte[_lengthPacket];
            DatagramPacket packet = new DatagramPacket(data2, data2.length);
            _socket.receive(packet);
            result = (new String(packet.getData())).trim();
        } catch(IOException e) { e.printStackTrace(); }
    }
}
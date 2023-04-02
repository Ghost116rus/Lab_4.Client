import FourthLabClient.UserInterface;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;


// Опишем задание клиента
// Работаем по UDP
// Адрес и порта сервера задаем с командной строки
// Журнал клиента мы определяем через файл настроек


public class Main {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();

        userInterface.Start();
    }
}
import FourthLabClient.UserInterface;


// Опишем задание клиента
// Работаем по UDP
// Адрес и порта сервера задаем с командной строки
// Журнал клиента мы определяем через файл настроек


public class Main {
    public static void main(String[] args) {

        UserInterface userInterface;
        if (args.length != 3)  {  userInterface = new UserInterface();  }
        else {  userInterface = new UserInterface(args);   }

        userInterface.Start();
    }
}
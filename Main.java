import managers.CollectionManager;
import managers.ConsoleManager;
import managers.FileManager;

import javax.xml.bind.JAXBException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        CollectionManager collectionManager = new CollectionManager(scanner);
        ConsoleManager consoleManager = new ConsoleManager(scanner);
        if (args.length > 1) {
            System.out.println("Программа принимает 1 аргумент(путь к файлу)");
            System.exit(1);
        } else {
            try {
                if (args.length == 1) collectionManager.addAll(FileManager.loadFromFile(args[0]));
            }catch (JAXBException e) {
                e.printStackTrace();
                System.out.println("Структура xml файла неверна\nФайл не был загружен");
            }
        }

        while (true) {
            System.out.print("Введите команду: ");
            if (scanner.hasNextLine()) {
                String command = scanner.nextLine().trim().toLowerCase(Locale.ROOT);
                consoleManager.executeCommand(command, collectionManager);
            } else {
                System.exit(0);
            }
        }
    }

}

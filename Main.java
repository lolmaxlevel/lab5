import managers.CollectionManager;
import managers.ConsoleManager;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CollectionManager collectionManager = new CollectionManager(scanner);
        ConsoleManager consoleManager = new ConsoleManager(scanner);

        while (true) {
            System.out.print("Введите команду: ");
            if (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                consoleManager.executeCommand(line, collectionManager);
            } else {
                System.exit(0);
            }
        }
    }

}

package commands;

import managers.CollectionManager;

import java.util.Scanner;

public class Info extends AbstractCommand {
    public static String alias = "info";
    static String description = "Вывод информации о коллекции";
    public Info(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void execute(String[] args, CollectionManager collectionManager) {

    }
}

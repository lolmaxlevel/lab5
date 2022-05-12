package commands;

import managers.CollectionManager;

import java.util.Scanner;

public class Exit extends AbstractCommand {
    public static String alias = "exit";
    static String description = "Выходит из программы без сохранения коллекции";
    public Exit(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void execute(String[] args, CollectionManager collectionManager) {
        System.exit(0);
    }
}

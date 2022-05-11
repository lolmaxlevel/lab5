package commands;

import utils.CollectionManager;

import java.util.Scanner;

public class Exit extends AbstractCommand {
    static String alias = "exit";
    static String description = "Выходит из программы без сохранения коллекции";
    public Exit(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void execute(String[] args, CollectionManager collectionManager) {
        System.exit(0);
    }
}

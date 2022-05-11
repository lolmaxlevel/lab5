package commands;

import utils.CollectionManager;

import java.util.Scanner;

public class Add extends AbstractCommand {
    static String alias = "add";
    static String description = "Добавление нового элемента в коллекцию";

    public Add(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void execute(String[] args, CollectionManager collectionManager) {

    }
}

package commands;

import utils.CollectionManager;

import java.util.Scanner;

public class Save extends AbstractCommand {
    static String alias = "save";
    static String description = "Сохраняет коллекцию в файл";
    public Save(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void execute(String[] args, CollectionManager collectionManager) {
        CollectionManager.saveToFile();
    }
}

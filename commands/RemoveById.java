package commands;

import utils.CollectionManager;

import java.util.Scanner;

public class RemoveById extends AbstractCommand {
    static String alias = "remove_by_id";
    static String description = "Удаление элемента из коллекции по id";
    public RemoveById(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void execute(String[] args, CollectionManager collectionManager) {
        //TODO доделать=)
    }
}

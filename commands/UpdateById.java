package commands;

import managers.CollectionManager;

import java.util.Scanner;

public class UpdateById extends AbstractCommand {
    public static String alias = "update_by_id";
    static String description = "Обновить элемент коллекции по id";
    public UpdateById(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void execute(String[] args, CollectionManager collectionManager) {
        //TODO доделать=)
    }
}

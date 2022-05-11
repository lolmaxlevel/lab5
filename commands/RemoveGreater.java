package commands;

import utils.CollectionManager;

import java.util.Scanner;

public class RemoveGreater extends AbstractCommand {
    static String alias = "remove_greater";
    static String description = "Удаляет элементы дороже заданного";
    public RemoveGreater(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void execute(String[] args, CollectionManager collectionManager) {
        collectionManager.removeGreater(price);
    }
}

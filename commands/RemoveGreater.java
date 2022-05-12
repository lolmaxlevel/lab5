package commands;

import managers.CollectionManager;

import java.util.Scanner;

public class RemoveGreater extends AbstractCommand {
    public static String alias = "remove_greater";
    static String description = "Удаляет элементы дороже заданного";
    public RemoveGreater(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void execute(String[] args, CollectionManager collectionManager) {
        int price = Integer.parseInt(args[0]);
        collectionManager.removeGreater(price);
    }
}

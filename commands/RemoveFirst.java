package commands;

import utils.CollectionManager;

import java.util.Scanner;

public class RemoveFirst extends AbstractCommand {
    static String alias = "remove_first";
    static String description = "Удаляет первый элемент коллекции";
    public RemoveFirst(Scanner scanner) {
        super(scanner);
    }


    @Override
    public void execute(String[] args, CollectionManager collectionManager) {
        collectionManager.removeFirst();
    }
}

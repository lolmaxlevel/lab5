package commands;

import utils.CollectionManager;

import java.util.Scanner;

public class RemoveLower extends AbstractCommand {
    static String alias = "remove_lower";
    static String description = "Удаляет элементы дешевле заданного";
    public RemoveLower(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void execute(String[] args, CollectionManager collectionManager) {

    }
}

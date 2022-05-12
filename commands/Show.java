package commands;

import managers.CollectionManager;

import java.util.Scanner;

public class Show extends AbstractCommand {
    public static String alias = "show";
    static String description = "Вывод все элементы коллекции";
    public Show(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void execute(String[] args, CollectionManager collectionManager) {
        //TODO доделать
    }
}

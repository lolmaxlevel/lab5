package commands;

import exceptions.WrongAmountOfArgsException;
import managers.CollectionManager;

import java.util.Scanner;

public class Add extends AbstractCommand {
    public static final String alias = "add";
    public static final String description = "Добавление нового элемента в коллекцию";
    private static final String[] acceptedArgs = {};

    public static String getDescription() {
        return description;
    }

    public Add(Scanner scanner) {
        super(scanner);
    }

    public static String getAlias() {
        return alias;
    }

    @Override
    public void execute(String[] args, CollectionManager collectionManager) throws WrongAmountOfArgsException {
        if (args.length != acceptedArgs.length){
            throw new WrongAmountOfArgsException(String.valueOf(acceptedArgs.length),
                    String.join(" ", acceptedArgs));
        }
        else {
            collectionManager.add();
        }
    }
}

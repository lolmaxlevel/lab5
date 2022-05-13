package commands;

import exceptions.WrongAmountOfArgsException;
import managers.CollectionManager;

import java.util.Scanner;

public class Save extends AbstractCommand {
    public static String alias = "save";
    static String description = "Сохраняет коллекцию в файл";
    private static final String[] acceptedArgs = {};
    public Save(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void execute(String[] args, CollectionManager collectionManager) throws WrongAmountOfArgsException {
        if (args.length != acceptedArgs.length){
            throw new WrongAmountOfArgsException(String.valueOf(acceptedArgs.length),
                    String.join(" ", acceptedArgs));
        }
        else {
            //CollectionManager.saveToFile();
        }
    }
}

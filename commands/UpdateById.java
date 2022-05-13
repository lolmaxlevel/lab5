package commands;

import exceptions.WrongAmountOfArgsException;
import managers.CollectionManager;

import java.util.Scanner;

public class UpdateById extends AbstractCommand {
    public static String alias = "update_by_id";
    static String description = "Обновить элемент коллекции по id";
    private static final String[] acceptedArgs = {};

    public UpdateById(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void execute(String[] args, CollectionManager collectionManager) throws WrongAmountOfArgsException {
        if (args.length != acceptedArgs.length){
            throw new WrongAmountOfArgsException(String.valueOf(acceptedArgs.length),
                    String.join(" ", acceptedArgs));
        }
        else {
            //TODO
        }
    }
}

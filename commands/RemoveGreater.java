package commands;

import exceptions.WrongAmountOfArgsException;
import managers.CollectionManager;

import java.util.Scanner;

public class RemoveGreater extends AbstractCommand {
    public static String alias = "remove_greater";
    static String description = "Удаляет элементы дороже заданного";
    private static final String[] acceptedArgs = {"Product"};

    public RemoveGreater(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void execute(String[] args, CollectionManager collectionManager) throws WrongAmountOfArgsException {
        if (args.length != acceptedArgs.length){
            throw new WrongAmountOfArgsException(String.valueOf(acceptedArgs.length),
                    String.join(" ", acceptedArgs));
        }
        else {
            int price = Integer.parseInt(args[0]);
            collectionManager.removeGreater(price);
        }
    }
}

package commands;

import exceptions.WrongAmountOfArgsException;
import managers.CollectionManager;

import java.util.Scanner;

public class Clear extends AbstractCommand {
     public static final String alias = "clear";
     public static final String description = "Очистить коллекцию";
    private static final String[] acceptedArgs = {};

    public static String getAlias() {
        return alias;
    }

    public static String getDescription() {
        return description;
    }

    public Clear(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void execute(String[] args, CollectionManager collectionManager) throws WrongAmountOfArgsException {
        if (args.length != acceptedArgs.length){
            throw new WrongAmountOfArgsException(String.valueOf(acceptedArgs.length),
                    String.join(" ", acceptedArgs));
        }
        else {
            if (collectionManager.isEmpty()){
                System.out.println("Коллекция уже пуста");
            }else {
                collectionManager.clear();
                System.out.println("Коллекция очищена");
            }
        }


    }
}

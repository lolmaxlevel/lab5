package commands;

import exceptions.WrongAmountOfArgsException;
import managers.CollectionManager;

import java.util.Scanner;

public class RemoveById extends AbstractCommand {
    public static String alias = "remove_by_id";
    static String description = "Удаление элемента из коллекции по id";
    private static final String[] acceptedArgs = {"id"};
    public RemoveById(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void execute(String[] args, CollectionManager collectionManager) throws WrongAmountOfArgsException {
        if (args.length != acceptedArgs.length){
            throw new WrongAmountOfArgsException(String.valueOf(acceptedArgs.length),
                    String.join(" ", acceptedArgs));
        }
        else {
            try {
                collectionManager.removeByID(Integer.parseInt(args[0]));
                System.out.println("Элемент коллекции удален");
            } catch (NumberFormatException e){System.out.println("Команда принимает аргументы:"+String.join(",", acceptedArgs));}
        }
    }
}

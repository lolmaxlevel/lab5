package commands;

import exceptions.WrongAmountOfArgsException;
import managers.CollectionManager;

import java.util.Scanner;
/**
 * Класс команды remove first
 */
public class RemoveFirst extends AbstractCommand {
    public static String alias = "remove_first";
    static String description = "Удаляет первый элемент коллекции";
    private static final String[] acceptedArgs = {};
    public RemoveFirst(Scanner scanner) {
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
                System.out.println("Коллекция пуста");
            } else collectionManager.removeFirst();
        }
    }
}

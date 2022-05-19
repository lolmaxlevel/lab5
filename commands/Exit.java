package commands;

import exceptions.WrongAmountOfArgsException;
import managers.CollectionManager;

import java.util.Scanner;
/**
 * Класс команды execute exit
 */

public class Exit extends AbstractCommand {
    public static String alias = "exit";
    static String description = "Выходит из программы без сохранения коллекции";
    private static final String[] acceptedArgs = {};
    public Exit(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void execute(String[] args, CollectionManager collectionManager) throws WrongAmountOfArgsException {
        if (args.length != acceptedArgs.length){
            throw new WrongAmountOfArgsException(String.valueOf(acceptedArgs.length),
                    String.join(" ", acceptedArgs));
        }
        else {
            System.exit(0);
        }
    }
}

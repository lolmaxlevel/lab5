package commands;

import exceptions.WrongAmountOfArgsException;
import managers.CollectionManager;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Класс команды Info
 */

public class Info extends AbstractCommand {
    public static String alias = "info";
    static String description = "Вывод информации о коллекции";
    private static final String[] acceptedArgs = {};
    public Info(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void execute(String[] args, CollectionManager collectionManager) throws WrongAmountOfArgsException {
        if (args.length != acceptedArgs.length){
            throw new WrongAmountOfArgsException(String.valueOf(acceptedArgs.length),
                    String.join(" ", acceptedArgs));
        }
        else {
            System.out.println("Тип: " + collectionManager.getCollection().getClass().getName()
                    +"\nДата инициализации: " +
                    collectionManager.getCreationDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))+
            "\nКоличество элементов: " + collectionManager.getSize());
        }
    }
}

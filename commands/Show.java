package commands;

import exceptions.WrongAmountOfArgsException;
import managers.CollectionManager;
import myCollection.Product;

import java.util.Scanner;
/**
 * Класс команды show
 */

public class Show extends AbstractCommand {
    public static String alias = "show";
    static String description = "Вывод все элементы коллекции";
    private static final String[] acceptedArgs = {};

    public Show(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void execute(String[] args, CollectionManager collectionManager) throws WrongAmountOfArgsException {
        if (args.length != acceptedArgs.length) {
            throw new WrongAmountOfArgsException(String.valueOf(acceptedArgs.length),
                    String.join(" ", acceptedArgs));
        } else {
            if (collectionManager.isEmpty()) System.out.println("Коллекция пуста");
            else {
                for (Product p : collectionManager.getCollection()) {
                    System.out.println(p);
                    System.out.println("\n");
                }
            }
        }
    }
}
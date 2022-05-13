package commands;

import exceptions.WrongAmountOfArgsException;
import managers.CollectionManager;

import java.util.Scanner;

public class PrintFieldDescendingPrice extends AbstractCommand{
    public static String alias = "print_field_descending_price";
    static String description = "Выводит все цены в порядке убывания";
    private static final String[] acceptedArgs = {};
    public PrintFieldDescendingPrice(Scanner scanner) {
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

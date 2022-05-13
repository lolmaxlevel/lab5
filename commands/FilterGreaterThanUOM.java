package commands;

import exceptions.WrongAmountOfArgsException;
import managers.CollectionManager;

import java.util.Scanner;

public class FilterGreaterThanUOM extends AbstractCommand{
    public static String alias = "filter_greater_than_UOM";
    static String description = "Выводит элементы у которых поле unitOfMeasure больше данного";
    private static final String[] acceptedArgs = {"UnitOfMeasure"};
    public FilterGreaterThanUOM(Scanner scanner) {
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

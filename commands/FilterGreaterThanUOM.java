package commands;

import exceptions.WrongAmountOfArgsException;
import managers.CollectionManager;
import myCollection.Product;
import myCollection.UnitOfMeasure;

import java.util.Scanner;
/**
 * Класс команды Filter Greater Than unite_of_measure
 */
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
            try {
                int c = 0;
                UnitOfMeasure UOM = UnitOfMeasure.valueOf(args[0]);
                for (Product p : collectionManager.getCollection()) {
                    if (p.getUnitOfMeasure() != null){
                        if (p.getUnitOfMeasure().compareTo(UOM) < 0){
                            System.out.println(p);
                            c++;
                        }
                    }
                }
                if (c==0){
                    System.out.println("Нет таких элементов");
                }
            }catch (IllegalArgumentException e)
            {System.out.println("Неверный аргумент команды");
            }
        }
    }
}

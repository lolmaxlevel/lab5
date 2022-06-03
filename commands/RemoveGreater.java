package commands;

import commands.exceptions.WrongAmountOfArgsException;
import commands.exceptions.WrongArgException;
import managers.CollectionManager;
import mycollection.Product;
import utils.MakeProduct;

import java.util.Scanner;
/**
 * Класс команды remove greater
 */
public class RemoveGreater extends AbstractCommand {
    public static String alias = "remove_greater";
    static String description = "Удаляет элементы лучше заданного";
    private static final String[] acceptedArgs = {};

    public RemoveGreater(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void execute(String[] args, CollectionManager collectionManager) throws WrongAmountOfArgsException, WrongArgException {
        if (args.length != acceptedArgs.length){
            throw new WrongAmountOfArgsException(String.valueOf(acceptedArgs.length),
                    String.join(" ", acceptedArgs));
        }
        else {
            MakeProduct makeProduct = new MakeProduct(getScanner());
            Product pr = new Product(makeProduct.askName(0), makeProduct.askCoordinates(), makeProduct.askPrice(), makeProduct.askManufactureCost(),
                    makeProduct.askUOM(), makeProduct.askOwner());
            collectionManager.removeGreater(pr);
        }
    }
}

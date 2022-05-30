package commands;

import exceptions.WrongAmountOfArgsException;
import exceptions.WrongArgException;
import managers.CollectionManager;
import myCollection.Product;
import utils.MakeProduct;

import java.util.Scanner;
/**
 * Класс команды remove lower
 */
public class RemoveLower extends AbstractCommand {
    public static String alias = "remove_lower";
    static String description = "Удаляет элементы дешевле заданного";
    private static final String[] acceptedArgs = {};
    public RemoveLower(Scanner scanner) {
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
            collectionManager.removeLower(pr);
        }
    }
}

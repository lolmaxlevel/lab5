package commands;

import exceptions.WrongAmountOfArgsException;
import exceptions.WrongArgException;
import managers.CollectionManager;
import myCollection.Product;
import utils.MakeProduct;

import java.util.Scanner;

public class RemoveGreater extends AbstractCommand {
    public static String alias = "remove_greater";
    static String description = "Удаляет элементы дороже заданного";
    private static final String[] acceptedArgs = {"Product"};

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
            Product pr = new Product(makeProduct.askName(), makeProduct.askCoordinates(), makeProduct.askPrice(), makeProduct.askManufactureCost(),
                    makeProduct.askUOM(), makeProduct.askOwner());
            collectionManager.removeGreater(pr);
        }
    }
}

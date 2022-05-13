package commands;

import exceptions.WrongAmountOfArgsException;
import exceptions.WrongArgException;
import managers.CollectionManager;
import myCollection.Person;
import myCollection.Product;
import myCollection.UnitOfMeasure;
import utils.MakeProduct;

import java.util.Scanner;

public class Add extends AbstractCommand {
    public static final String alias = "add";
    public static final String description = "Добавление нового элемента в коллекцию";
    private static final String[] acceptedArgs = {};
    private final MakeProduct makeProduct;

    public static String getDescription() {
        return description;
    }

    public Add(Scanner scanner) {
        super(scanner);
        this.makeProduct = new MakeProduct(scanner);
    }

    public static String getAlias() {
        return alias;
    }

    @Override
    public void execute(String[] args, CollectionManager collectionManager) throws WrongAmountOfArgsException, WrongArgException {
        if (args.length != acceptedArgs.length){
            throw new WrongAmountOfArgsException(String.valueOf(acceptedArgs.length),
                    String.join(" ", acceptedArgs));
        }
        else {
            collectionManager.addItem(new Product(makeProduct.askName(), makeProduct.askCoordinates(), makeProduct.askPrice(), makeProduct.askManufactureCost(),
                   makeProduct.askUOM(), makeProduct.askOwner()));
        }
    }
}

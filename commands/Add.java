package commands;

import exceptions.WrongAmountOfArgsException;
import exceptions.WrongArgException;
import managers.CollectionManager;
import myCollection.Product;
import utils.MakeProduct;

import java.util.Scanner;

public class Add extends AbstractCommand {
    /**
     *Класс команды который
     */
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
    /**
     * Выполняет добавление элемента в коллекцию
     * @param args аргументы из командной строки
     * @param collectionManager менеджер коллекции
     * @throws WrongAmountOfArgsException исключение если даны неверные аргументы
     */
    @Override
    public void execute(String[] args, CollectionManager collectionManager) throws WrongAmountOfArgsException, WrongArgException {
        if (args.length != acceptedArgs.length){
            throw new WrongAmountOfArgsException(String.valueOf(acceptedArgs.length),
                    String.join(" ", acceptedArgs));
        }
        else {
            collectionManager.addItem(new Product(makeProduct.askName(0), makeProduct.askCoordinates(), makeProduct.askPrice(), makeProduct.askManufactureCost(),
                   makeProduct.askUOM(), makeProduct.askOwner()));
        }
    }
}

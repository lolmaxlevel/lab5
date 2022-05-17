package commands;

import exceptions.NotFoundIdException;
import exceptions.WrongAmountOfArgsException;
import exceptions.WrongArgException;
import managers.CollectionManager;
import myCollection.Product;
import utils.MakeProduct;

import java.util.Scanner;

public class UpdateById extends AbstractCommand {
    public static String alias = "update_by_id";
    static String description = "Обновить элемент коллекции по id";
    private static final String[] acceptedArgs = {"id"};

    public UpdateById(Scanner scanner) {
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
                MakeProduct makeProduct = new MakeProduct(getScanner());
                Product prod = collectionManager.getElementById(Integer.parseInt(args[0]));
                prod.setName(makeProduct.askName());
                prod.setCoordinates(makeProduct.askCoordinates());
                prod.setPrice(makeProduct.askPrice());
                prod.setManufactureCost(makeProduct.askManufactureCost());
                prod.setUnitOfMeasure(makeProduct.askUOM());
                prod.setOwner(makeProduct.askOwner());
            } catch (WrongArgException e) {
                System.out.println("Вы ввели неправильное значение");
            }catch (NumberFormatException e){
                System.out.println("Неверный id(id-целое число, введите show для простоты)");
            } catch (NotFoundIdException e) {
                System.out.println("Такого id нет в коллекции");
            }
        }
    }
}

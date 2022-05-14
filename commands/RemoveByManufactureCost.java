package commands;

import exceptions.WrongAmountOfArgsException;
import managers.CollectionManager;

import java.util.Objects;
import java.util.Scanner;

public class RemoveByManufactureCost extends AbstractCommand {
    public static String alias = "remove_by_manufacture_cost";
    static String description = "Удаляет все элементы коллекции которые дешевле данного";
    private static final String[] acceptedArgs = {"price"};
    public RemoveByManufactureCost(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void execute(String[] args, CollectionManager collectionManager) throws WrongAmountOfArgsException {
        if (args.length != acceptedArgs.length){
            throw new WrongAmountOfArgsException(String.valueOf(acceptedArgs.length),
                    String.join(" ", acceptedArgs));
        }
        else {
            if (Objects.equals(args[0], "null")) {
                collectionManager.removeByManufactureCost(null);
            } else {
                try {
                    collectionManager.removeByManufactureCost(Long.parseLong(args[0]));
                    System.out.println("Элементы коллекции удалены");
            } catch (NumberFormatException e){System.out.println("Команда принимает аргументы:"+String.join(",", acceptedArgs));}
            }
        }
    }
}

package commands;

import managers.CollectionManager;

import java.util.Scanner;

public class RemoveByManufactureCost extends AbstractCommand {
    public static String alias = "remove_by_manufacture_cost";
    static String description = "Удаляет все элементы коллекции которые дешевле данного";
    public RemoveByManufactureCost(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void execute(String[] args, CollectionManager collectionManager) {

    }
}

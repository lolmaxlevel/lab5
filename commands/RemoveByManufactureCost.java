package commands;

import utils.CollectionManager;

import java.util.Scanner;

public class RemoveByManufactureCost extends AbstractCommand {
    static String alias = "remove_by_manufacture_cost";
    static String description = "Удаляет все элементы коллекции которые дешевле данного";
    public RemoveByManufactureCost(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void execute(String[] args, CollectionManager collectionManager) {

    }
}

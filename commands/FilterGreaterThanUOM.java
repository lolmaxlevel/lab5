package commands;

import managers.CollectionManager;

import java.util.Scanner;

public class FilterGreaterThanUOM extends AbstractCommand{
    public static String alias = "filter_greater_than_UOM";
    static String description = "Выводит элементы у которых поле unitOfMeasure больше данного";
    public FilterGreaterThanUOM(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void execute(String[] args, CollectionManager collectionManager) {

    }
}

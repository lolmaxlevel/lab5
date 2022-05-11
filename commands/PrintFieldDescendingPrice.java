package commands;

import utils.CollectionManager;

import java.util.Scanner;

public class PrintFieldDescendingPrice extends AbstractCommand{
    static String alias = "print_field_descending_price";
    static String description = "Выводит все цены в порядке убывания";
    public PrintFieldDescendingPrice(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void execute(String[] args, CollectionManager collectionManager) {

    }
}

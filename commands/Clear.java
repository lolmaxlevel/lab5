package commands;

import utils.CollectionManager;

import java.util.Scanner;

public class Clear extends AbstractCommand {
    static String alias = "clear";
    static String description = "Очистить коллекцию";
    public Clear(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void execute(String[] args, CollectionManager collectionManager) {
        if (collectionManager.isEmpty){
            System.out.println("Коллекция уже пуста");
        }else {
            collectionManager.clear;
            System.out.println("Коллекция очищена");
        }

    }
}

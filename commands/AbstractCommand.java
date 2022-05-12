package commands;

import exceptions.WrongAmountOfArgsException;
import managers.CollectionManager;

import java.util.Scanner;

public abstract class AbstractCommand {
    private final Scanner scanner;
    static String alias;
    static String description;

    public AbstractCommand(Scanner scanner){
        this.scanner = scanner;
    }
    public Scanner getScanner(){return scanner;}

    public static String getAlias() {
        return alias;
    }

    public static String getDescription() {
        return description;
    }

    public abstract void execute(String[] args, CollectionManager collectionManager) throws WrongAmountOfArgsException;
}


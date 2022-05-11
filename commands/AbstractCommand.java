package commands;

import utils.CollectionManager;

import java.util.Scanner;

public abstract class AbstractCommand {
    private Scanner scanner;
    static String alias;
    static String description;

    public AbstractCommand(Scanner scanner){
        this.scanner = scanner;
    }
    public Scanner getScanner(){return scanner;}
    public abstract void execute(String[] args, CollectionManager collectionManager);
}


package commands;

import utils.CollectionManager;

import java.util.Scanner;

public class ExecuteScript extends AbstractCommand {
    static String alias = "execute_script";
    static String description = "Выполняет скрипт из файла";
    public ExecuteScript(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void execute(String[] args, CollectionManager collectionManager) {
        //TODO доделать=)
    }
}

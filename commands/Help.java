package commands;

import exceptions.WrongAmountOfArgsException;
import managers.CollectionManager;

import java.util.Scanner;
/**
 * Класс команды help
 */

public class Help extends AbstractCommand {
    public static String alias = "help";
    static String description = "Вывод данного сообщения";
    private static final String[] acceptedArgs = {};
    public Help(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void execute(String[] args, CollectionManager collectionManager) throws WrongAmountOfArgsException {
        if (args.length != acceptedArgs.length){
            throw new WrongAmountOfArgsException(String.valueOf(acceptedArgs.length),
                    String.join(" ", acceptedArgs));
        }
        else {
            System.out.println(Info.alias + ":\n\t" + Info.description);
            System.out.println(Help.alias + ":\n\t" + Help.description);
            System.out.println(Add.alias + ":\n\t" + Add.description);
            System.out.println(Clear.alias + ":\n\t" + Clear.description);
            System.out.println(ExecuteScript.alias + ":\n\t" + ExecuteScript.description);
            System.out.println(Exit.alias + ":\n\t" + Exit.description);
            System.out.println(FilterGreaterThanUOM.alias + ":\n\t" + FilterGreaterThanUOM.description);
            System.out.println(PrintFieldDescendingPrice.alias + ":\n\t" + PrintFieldDescendingPrice.description);
            System.out.println(RemoveById.alias + ":\n\t" + RemoveById.description);
            System.out.println(RemoveByManufactureCost.alias + ":\n\t" + RemoveByManufactureCost.description);
            System.out.println(RemoveFirst.alias + ":\n\t" + RemoveFirst.description);
            System.out.println(RemoveGreater.alias + ":\n\t" + RemoveGreater.description);
            System.out.println(RemoveLower.alias + ":\n\t" + RemoveLower.description);
            System.out.println(Save.alias + ":\n\t" + Save.description);
            System.out.println(Show.alias + ":\n\t" + Show.description);
            System.out.println(UpdateById.alias + ":\n\t" + UpdateById.description);
        }
    }
}

package commands;

import commands.exceptions.WrongAmountOfArgsException;
import commands.exceptions.WrongArgException;
import managers.CollectionManager;
import managers.FileManager;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Класс команды save
 */
public class Save extends AbstractCommand {
    public static String alias = "save";
    static String description = "Сохраняет коллекцию в файл";
    String filepath;
    public Save(Scanner scanner) {
        super(scanner);
    }
    @Override
    public void execute(String[] args, CollectionManager collectionManager) throws WrongAmountOfArgsException, WrongArgException {
        {
            try {
                if (args.length == 0) filepath = "";
                else filepath = args[0];
                if (collectionManager.isEmpty()) System.out.println("Коллекция пуста, нечего сохранять");
                else FileManager.saveToFile(collectionManager, filepath);
            } catch (JAXBException | FileNotFoundException e) {
                System.out.println("Сохранить коллекцию не удалось(проверьте доступ к файлу и папке)");
            }
        }
    }
}

package commands;

import exceptions.WrongAmountOfArgsException;
import exceptions.WrongArgException;
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
    private static final String[] acceptedArgs = {};
    public Save(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void execute(String[] args, CollectionManager collectionManager) throws WrongAmountOfArgsException, WrongArgException {
        if (args.length != acceptedArgs.length){
            throw new WrongAmountOfArgsException(String.valueOf(acceptedArgs.length),
                    String.join(" ", acceptedArgs));
        }
        else {
            try {
                if (collectionManager.isEmpty()) System.out.println("Коллекция пуста, нечего сохранять");
                else FileManager.saveToFile("D:\\", collectionManager);
            } catch (JAXBException | FileNotFoundException e) {
                System.out.println("Сохранить коллекцию не удалось(проверьте доступ к файлу и папке)");
            }
        }
    }
}

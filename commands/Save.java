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
    private static final String[] acceptedArgs = {"file path"};
    String file_path;
    public Save(Scanner scanner) {
        super(scanner);
    }
    @Override
    public void execute(String[] args, CollectionManager collectionManager) throws WrongAmountOfArgsException, WrongArgException {
        if (args.length != acceptedArgs.length){
            System.out.println("Не указан путь для сохранения, коллекция будет сохранена в данную директорию");
            file_path = "";
        }
        else {
            try {
                file_path = args[0];
                if (collectionManager.isEmpty()) System.out.println("Коллекция пуста, нечего сохранять");
                else FileManager.saveToFile(collectionManager, file_path);
            } catch (JAXBException | FileNotFoundException e) {
                System.out.println("Сохранить коллекцию не удалось(проверьте доступ к файлу и папке)");
            }
        }
    }
}

package managers;

import commands.*;
import exceptions.WrongAmountOfArgsException;
import exceptions.WrongArgException;

import javax.xml.bind.JAXBException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class ConsoleManager {
    private final HashMap<String, AbstractCommand> commands = new HashMap<>();
    private Scanner scanner;
    public ConsoleManager(Scanner scanner){
        this.scanner = scanner;
        commands.put(Add.alias, new Add(scanner));
        commands.put(Clear.alias, new Clear(scanner));
        commands.put(ExecuteScript.alias, new ExecuteScript(scanner));
        commands.put(Exit.alias, new Exit(scanner));
        commands.put(FilterGreaterThanUOM.alias, new FilterGreaterThanUOM(scanner));
        commands.put(Help.alias, new Help(scanner));
        commands.put(Info.alias, new Info(scanner));
        commands.put(PrintFieldDescendingPrice.alias, new PrintFieldDescendingPrice(scanner));
        commands.put(RemoveById.alias, new RemoveById(scanner));
        commands.put(RemoveByManufactureCost.alias, new RemoveByManufactureCost(scanner));
        commands.put(RemoveFirst.alias, new RemoveFirst(scanner));
        commands.put(RemoveGreater.alias, new RemoveGreater(scanner));
        commands.put(RemoveLower.alias, new RemoveLower(scanner));
        commands.put(Save.alias, new Save(scanner));
        commands.put(Show.alias, new Show(scanner));
        commands.put(UpdateById.alias, new UpdateById(scanner));
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void executeCommand(String commandLine, CollectionManager collectionManager){
        String[] args = commandLine.split("\\s+");
        String commandName = args[0];
        args = Arrays.copyOfRange(args, 1, args.length);
        if (commands.containsKey(commandName)) {
            try{
                commands.get(commandName).execute(args, collectionManager);
            } catch (WrongAmountOfArgsException e) {
                System.out.println(e.getMessage());
            } catch (WrongArgException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Такой команды нет. Введите help, чтобы получить список и описание команд.");
        }
    }

}

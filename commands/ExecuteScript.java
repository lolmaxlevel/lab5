package commands;

import exceptions.ScriptLoopException;
import exceptions.WrongAmountOfArgsException;
import managers.CollectionManager;
import managers.ConsoleManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Locale;
import java.util.Scanner;
import java.util.Stack;

public class ExecuteScript extends AbstractCommand {
    public static String alias = "execute_script";
    static String description = "Выполняет скрипт из файла";
    private static final String[] acceptedArgs = {"file_path"};
    public static Stack<String> scriptStack = new Stack<>();
    public static PrintStream console = System.out;
    public ExecuteScript(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void execute(String[] args, CollectionManager collectionManager) throws WrongAmountOfArgsException {
        if (args.length != acceptedArgs.length){
            throw new WrongAmountOfArgsException(String.valueOf(acceptedArgs.length),
                    String.join(" ", acceptedArgs));
        }
        else {
            try {
                if (scriptStack.contains(args[0].toLowerCase(Locale.ROOT))) throw new ScriptLoopException(console);

                scriptStack.push(args[0].toLowerCase(Locale.ROOT));

                Scanner scriptScanner = new Scanner(new File(args[0]));

                ConsoleManager scriptConsoleManager = new ConsoleManager(scriptScanner);
                PrintStream fileOut = new PrintStream("script_output.txt");
                System.setOut(fileOut);
                while (scriptScanner.hasNextLine()) {
                    scriptConsoleManager.executeCommand(scriptScanner.nextLine().trim(), collectionManager);
                }
                fileOut.close();
                System.setOut(console);
                System.out.println("Скрипт выполнен");

            }catch (FileNotFoundException e){
                System.out.println("Нет такого файла или недостаточно прав");
            }catch (ScriptLoopException e){
                System.out.println("Нельзя вызывать скрипт из самого себя");
            }
        }
    }
}

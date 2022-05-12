package exceptions;

public class WrongAmountOfArgsException extends Exception{
    public WrongAmountOfArgsException() {
    }

    public WrongAmountOfArgsException(String message, String args) {
        super("Команда принимает"+message+"аргументов" + ((args.isEmpty()) ? args : ""));
    }

    public WrongAmountOfArgsException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongAmountOfArgsException(Throwable cause) {
        super(cause);
    }
}

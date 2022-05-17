package exceptions;

import java.io.PrintStream;

public class ScriptLoopException extends Exception{
    public ScriptLoopException(PrintStream c){
        System.setOut(c);
    }
}

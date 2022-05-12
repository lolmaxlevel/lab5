package exceptions;

public class WrongArgException extends Exception{
    public WrongArgException(){
        super("Вы ввели неправильное значение!");
    }
    public WrongArgException(String field){
        super("Вы ввели неправильное значение!"+"поле"+field);
    }
}

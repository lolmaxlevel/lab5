package exceptions;

public class WrongArgException extends Exception{
    public WrongArgException(){
        super("Вы ввели неправильное значение!");
    }
    public WrongArgException(String field){
        System.out.println("Неправильное значение в xml файле! "+"поле "+field);
    }
}

package utils;

import exceptions.WrongArgException;
import exceptions.WrongInputException;
import myCollection.Coordinates;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class MakeProduct {
    private final Scanner scanner;

    public MakeProduct(Scanner scanner){
        this.scanner = scanner;
    }
    public String askName(){
        System.out.print("Введите имя товара:");
        while (true){
            try {
                String name = scanner.nextLine().trim();
                if (name.equals("null") || name.isEmpty()) throw new WrongInputException();
                else return name;
            } catch (NoSuchElementException e) {
                System.exit(1);
            } catch (WrongInputException e) {
                System.out.println("Что-то пошло не так, повторите ввод");
            }
        }
    }
    public Coordinates coordinates() throws WrongArgException {
        return new Coordinates(askX(), askY());
    }
    public Integer askX(){
        System.out.print("Введите координату X товара:");
        while (true){
            try {
                if (scanner.hasNextInt()){
                    int x = scanner.nextInt();
                    if (x<=6) return new Integer(x);
                } else throw new WrongInputException();
            } catch (WrongInputException e) {
                System.out.println("Что-то пошло не так, повторите ввод");
            }
        }
    }
    public float askY(){
        System.out.print("Введите координату Y товара:");
        while (true){
            try {
                if (scanner.hasNextFloat()){
                    return scanner.nextFloat();
                } else throw new WrongInputException();
            } catch (WrongInputException e) {
                System.out.println("Что-то пошло не так, повторите ввод");
            }
        }
    }
}

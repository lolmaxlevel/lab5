package myCollection;

import exceptions.WrongArgException;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private long weight; //Значение поля должно быть больше 0
    private String passportID; //Значение этого поля должно быть уникальным, Длина строки не должна быть больше 38, Длина строки должна быть не меньше 4, Поле не может быть null
    private static final List<String> passportIDs = new ArrayList<>();
    @Override
    public String toString() {
        return
                "Имя " + name +
                ", вес " + weight +
                ", номер паспорта " + passportID;
    }

    private String[] existingIDs;
    public Person(String name, long weight, String passportID) throws WrongArgException {
        setName(name);
        setWeight(weight);
        setPassportID(passportID);
        passportIDs.add(passportID);
    }
    public Person(){}

    public void setName(String name) throws WrongArgException {
        if(name != null && !name.isEmpty()){
            this.name = name;
        }
        else {
            throw new WrongArgException("Имя");
        }
    }

    public void setWeight(long weight) throws WrongArgException {
        if(weight >= 0){
            this.weight = weight;
        }
        else {
            throw new WrongArgException("Вес");
        }
    }

    public void setPassportID(String passportID) {
        this.passportID = passportID;
        passportIDs.add(passportID);
    }

    public String getName() {
        return name;
    }

    public long getWeight() {
        return weight;
    }

    public String getPassportID() {
        return passportID;
    }
    public static boolean checkPassportID(String potentialID){
        return !passportIDs.contains(potentialID);
    }
}

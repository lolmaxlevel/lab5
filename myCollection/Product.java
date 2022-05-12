package myCollection;

import java.time.ZonedDateTime;
import java.util.UUID;

public class Product implements Comparable<Product>{
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private double price; //Значение поля должно быть больше 0
    private Long manufactureCost; //Поле может быть null
    private UnitOfMeasure unitOfMeasure; //Поле может быть null
    private Person owner; //Поле может быть null
    public Product(int id, String name, Coordinates coordinates, double price,
                       Long manufactureCost, UnitOfMeasure unitOfMeasure, Person owner){
        this.id = this.generateId();
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = ZonedDateTime.now();
        this.price = price;
        this.manufactureCost = manufactureCost;
        this.unitOfMeasure = unitOfMeasure;
        this.owner = owner;
    }
    private int generateId(){
        UUID generatedId = UUID.randomUUID();
        return generatedId.hashCode();
    };
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public double getPrice() {
        return price;
    }

    public Long getManufactureCost() {
        return manufactureCost;
    }

    public Person getOwner() {
        return owner;
    }

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    @Override
    public String toString() {
        return
                "Продукт:" + name + "(" + id + ")" + ":\n" +
                "\nКоординаты:" + coordinates.toString() +
                "\nБыл создан:" + creationDate +
                "\nЦена:" + price +
                "\nЦена создания:" + manufactureCost +
                "\nЕдиницы измерения:" + unitOfMeasure.toString() +
                "\nВладелец:" + owner;

    }

    @Override
    public int compareTo(Product o) {
        return 0;
    }
}

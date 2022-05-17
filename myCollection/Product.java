package myCollection;

import utils.ZonedDateTimeAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.UUID;
@XmlRootElement(name = "book")
public class Product implements Comparable<Product>{
    @XmlElement(name = "id")
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    @XmlElement(name = "name")
    private String name; //Поле не может быть null, Строка не может быть пустой
    @XmlElement(name = "coordinates")
    private Coordinates coordinates; //Поле не может быть null

    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    @XmlElement(name = "price")
    private double price; //Значение поля должно быть больше 0
    @XmlElement(name = "manufactureCost")
    private Long manufactureCost; //Поле может быть null
    @XmlElement(name = "unitOfMeasure")
    private UnitOfMeasure unitOfMeasure; //Поле может быть null
    @XmlElement(name = "owner")
    private Person owner; //Поле может быть null
    public Product(String name, Coordinates coordinates, double price,
                       Long manufactureCost, UnitOfMeasure unitOfMeasure, Person owner){
        this.id = generateId();
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = getTime();
        this.price = price;
        this.manufactureCost = manufactureCost;
        this.unitOfMeasure = unitOfMeasure;
        this.owner = owner;
    }
    public Product(){}

    private static int generateId(){
        UUID generatedId = UUID.randomUUID();
        return Math.abs(generatedId.hashCode());
    }
    private static ZonedDateTime getTime(){
        return ZonedDateTime.now();
    }
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
    @XmlElement(name = "creationDate")
    @XmlJavaTypeAdapter(ZonedDateTimeAdapter.class)
    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return
                "Продукт:" + name + "(" + id + ")" + ":\n" +
                "Координаты:" + coordinates.toString() +
                "\nБыл создан:" + getCreationDate().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss")) +
                "\nЦена:" + price +
                "\nЦена создания:" + Objects.toString(manufactureCost, "null") +
                "\nЕдиницы измерения:" + Objects.toString(unitOfMeasure, "null") +
                "\nВладелец:" + owner;

    }
    @Override
    public int compareTo(Product o) {
            int result = this.name.compareTo(o.name);

            if (result == 0) {
                result = Double.compare(this.price, o.price);
            }
            if (result == 0) {
            result = this.creationDate.compareTo(o.creationDate);
            }
            return result;
        }
    }

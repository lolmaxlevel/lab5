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

    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null

    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private double price; //Значение поля должно быть больше 0
    private Long manufactureCost; //Поле может быть null
    private UnitOfMeasure unitOfMeasure; //Поле может быть null
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

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setManufactureCost(Long manufactureCost) {
        this.manufactureCost = manufactureCost;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }
    @XmlElement(name = "name")
    public String getName() {
        return name;
    }
    @XmlElement(name = "coordinates")
    public Coordinates getCoordinates() {
        return coordinates;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }
    @XmlElement(name = "price")
    public double getPrice() {
        return price;
    }
    @XmlElement(name = "manufactureCost")
    public Long getManufactureCost() {
        return manufactureCost;
    }
    @XmlElement(name = "owner")
    public Person getOwner() {
        return owner;
    }
    @XmlElement(name = "unitOfMeasure")
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

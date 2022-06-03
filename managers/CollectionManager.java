package managers;

import commands.exceptions.NotFoundIdException;
import mycollection.Product;
import utils.MakeProduct;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

/**
 *Класс для работы с коллекцией
 */
public class CollectionManager {
    private final ArrayList<Product> collection;
    MakeProduct makeProduct;
    ZonedDateTime creationDate;

    /**
     * Конструктор класса
     * @param scanner сканнер
     */
    public CollectionManager(Scanner scanner) {
        this.collection = new ArrayList<>();
        this.makeProduct = new MakeProduct(scanner);
        this.creationDate= ZonedDateTime.now();
    }

    /**
     * функция добавления элемента в коллекцию
     * @param abob Элемент коллекции(Экземпляр класса Product)
     */
    public void addItem(Product abob) {
        collection.add(abob);
        Collections.sort(collection);
        System.out.println("Продукт успешно добавлен");

    }

    /**
     * функция, которая проверят пустая ли коллекция
     * @return True если коллекция пустая
     */
    public boolean isEmpty(){
        return collection.isEmpty();
    }

    /**
     * функция очистки коллекции
     */
    public void clear(){
        collection.clear();
    }
    /**
     * функция удаления первого элемента коллекции
     */
    public void removeFirst(){
        Collections.sort(collection);
        collection.remove(0);
    }

    /**
     *
     * @return коллекция
     */
    public ArrayList<Product> getCollection(){
        Collections.sort(collection);
        return collection;
    }

    /**
     *
     * @return размер коллекции
     */
    public int getSize(){
        return collection.size();
    }

    /**
     * функция удаления даменита по id
     * @param id id элемента который нужно удалить
     */
    public void removeByID(int id){
        collection.removeIf(id1 -> id1.getId()==(id));
    }

    /**
     * функция, которая удаляет все элементы с заданной ценой
     * @param price цена по которой нужно удалить элементы
     */
    public void removeByManufactureCost(Long price){
        collection.removeIf(id1 -> Objects.equals(id1.getManufactureCost(), price));
    }

    /**
     * функция, которая удаляет все элементы которые "дороже" заданного
     * @param pr элемент относительно которого нужно удалять
     */
    public void removeGreater(Product pr){
        collection.add(pr);
        Collections.sort(collection);
        collection.indexOf(pr);
        collection.removeAll(collection.subList(0, collection.indexOf(pr) + 1));
        collection.remove(pr);
    }
    /**
     * функция, которая удаляет все элементы которые "дешевле" заданного
     * @param pr элемент относительно которого нужно удалять
     */
    public void removeLower(Product pr){
        collection.add(pr);
        Collections.sort(collection);
        collection.indexOf(pr);
        collection.removeAll(collection.subList(collection.indexOf(pr) + 1, collection.size()));
        collection.remove(pr);
    }

    /**
     *
     * @param products элементы которые нужно добавить в коллекцию
     */
    public void addAll(ArrayList<Product> products) {
        this.collection.addAll(products);
    }
    public ZonedDateTime getCreationDate(){
        return this.creationDate;
    }
    public Product getElementById(int id) throws NotFoundIdException {
        for(Product product: getCollection()) {
            if (product.getId() == id) {
                return product;
            }
        }
        throw new NotFoundIdException();
    }
}

package managers;

import exceptions.WrongArgException;
import myCollection.Product;
import utils.MakeProduct;

import java.util.ArrayList;
import java.util.Scanner;

public class CollectionManager {
    private final ArrayList<Product> collection;
    MakeProduct makeProduct;
    public CollectionManager(Scanner scanner) {
        this.collection = new ArrayList<>();
        this.makeProduct = new MakeProduct(scanner);
    }
    public void addItem(Product abob) {
        collection.add(abob);
        System.out.println("Продукт успешно добавлен");

    }
    public boolean isEmpty(){
        return collection.isEmpty();
    }
    public void clear(){
        collection.clear();
    }
    public void removeFirst(){
        collection.remove(0);
    }
    public void removeGreater(int a){
        //TODO
    }
}

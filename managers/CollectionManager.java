package managers;

import myCollection.Product;
import utils.MakeProduct;

import java.util.ArrayList;
import java.util.Objects;
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
    public void showAll(){

    }
    public ArrayList<Product> getCollection(){
        return collection;
    }
    public int getSize(){
        return collection.size();
    }
    public void removeByID(int id){
        collection.removeIf(id1 -> id1.getId()==(id));
    }
    public void removeByManufactureCost(Long price){
        collection.removeIf(id1 -> Objects.equals(id1.getManufactureCost(), price));
    }
}

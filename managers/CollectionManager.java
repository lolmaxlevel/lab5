package managers;

import myCollection.Product;
import utils.MakeProduct;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collections;
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
        Collections.sort(collection);
        System.out.println("Продукт успешно добавлен");

    }
    public boolean isEmpty(){
        return collection.isEmpty();
    }
    public void clear(){
        collection.clear();
    }
    public void removeFirst(){
        Collections.sort(collection);
        collection.remove(0);
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
    public void removeGreater(Product pr){
        collection.add(pr);
        Collections.sort(collection);
        collection.indexOf(pr);
        collection.removeAll(collection.subList(0, collection.indexOf(pr) + 1));
        collection.remove(pr);
    }
    public void removeLower(Product pr){
        collection.add(pr);
        Collections.sort(collection);
        collection.indexOf(pr);
        collection.removeAll(collection.subList(collection.indexOf(pr) + 1, collection.size()));
        collection.remove(pr);
    }
    public void addAll(ArrayList<Product> products) {
        this.collection.addAll(products);
    }
}

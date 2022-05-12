package managers;

import myCollection.Product;

import java.util.ArrayList;

public class CollectionManager {
    private final ArrayList<Product> collection;

    public CollectionManager() {
        this.collection = new ArrayList<>();

    }
    public void add(){
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
        System.out.println("111");
    }
}

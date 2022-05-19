package utils;

import myCollection.Product;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * дополнительный класс для работы JAXb
 */
@XmlRootElement(name = "Products")
public class ListHolder {

    ArrayList<Product> list = new ArrayList<>();

    public ArrayList<Product> getList() {
        return list;
    }

    @XmlElement (name="Product")
    public void setList(ArrayList<Product> list) {
        this.list = list;
    }


}
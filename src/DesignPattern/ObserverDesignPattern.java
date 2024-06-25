package src.DesignPattern;

import java.util.ArrayList;
import java.util.List;

public class ObserverDesignPattern {
    public static void main(String[] args) {
        Product product1 = new Product("123", "ABC1");
        Product product2 = new Product("456", "ABC2");
        Product product3 = new Product("789", "ABC3");
        Product product4 = new Product("012", "ABC4");

        Oberservers oberservers1 = new Oberservers("XYZ1", product1);
        Oberservers oberservers2 = new Oberservers("XYZ2", product2);
        Oberservers oberservers3 = new Oberservers("XYZ3", product3);
        Oberservers oberservers4 = new Oberservers("XYZ4", product4);

        Observable observable = new Observable();
        observable.addObservers(oberservers1);
        observable.addObservers(oberservers2);
        observable.addObservers(oberservers3);
        observable.addObservers(oberservers4);

        observable.addProduct(product1);
        observable.addProduct(product2);
        observable.addProduct(product3);
        observable.removeObservers(oberservers4);
        observable.addProduct(product4);
    }

}

class Observable {
    List<Oberservers> oberserversList = new ArrayList<>();
    List<Product> productList = new ArrayList<>();

    public void addObservers(Oberservers oberservers) {
        oberserversList.add(oberservers);
    }

    public void removeObservers(Oberservers oberservers) {
        oberserversList.remove(oberservers);
    }

    public void addProduct(Product product) {
        productList.add(product);
        notifyObservers(product);
    }

    public void notifyObservers(Product product) {
        for (Oberservers obj : oberserversList) {
            if(obj.productName == product){
                obj.update(obj);
            }
        }
    }
}

class Oberservers {
    public String name;
    public Product productName;

    Oberservers(String name, Product product) {
        this.name = name;
        this.productName = product;
    }

    public void update(Oberservers obj) {
        System.out.println("Notified user " + obj.name + " that product: " + obj.productName.productName
                + " with productId " + obj.productName.productId + " is available");
    }
}

class Product {
    public String productId;
    public String productName;

    Product(String id, String name) {
        this.productName = name;
        this.productId = id;
    }
}

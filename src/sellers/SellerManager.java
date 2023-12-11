package sellers;

import clients.Client;
import products.ConcreteProduct;
import products.ConcretePromotion;
import products.Product;
import products.Promotion;

import java.util.ArrayList;

public class SellerManager implements Seller {
    private String sellerId;
    private String name;
    private ArrayList<Product> products;
    private ArrayList<Promotion> promotions;
    private ArrayList<SellerObserver> observers;

    public SellerManager(String sellerId, String name) {
        this.sellerId = sellerId;
        this.name = name;
        this.products = new ArrayList<>();
        this.promotions = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    @Override
    public void register() {
        nofifyObservers("Seller registered " + name);
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
        nofifyObservers(product.getName() + " added ");
    }

    @Override
    public void configurePromotion(Product product, Promotion promotion) {
        promotions.add(promotion);
        nofifyObservers("Promotion configured " + promotion.getPromotionId());
    }

    @Override
    public void updateProduct(Product product) {
        nofifyObservers("Product updated " + product.getName());
    }

    public void addObserver(SellerObserver observer){
        observers.add(observer);
    }

    public void removeObserver(SellerObserver observer){
        observers.remove(observer);
    }

    public void nofifyObservers(String message){
        for(SellerObserver observer: observers){
            observer.update(message);
        }
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public ArrayList<Promotion> getPromotions() {
        return promotions;
    }
}

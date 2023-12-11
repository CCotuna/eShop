package sellers;

import clients.Client;
import products.ConcreteProduct;
import products.ConcretePromotion;
import products.Product;
import products.Promotion;

public interface Seller {
    void register();
    void addProduct(Product product);
    void configurePromotion(Product product, Promotion promotion);
    void updateProduct(Product product);
}

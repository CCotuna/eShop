package products;

import java.util.ArrayList;

public class ProductManager {
    private ArrayList<ConcreteProduct> products;

    public ProductManager() {
        this.products = new ArrayList<>();
    }

    public void addProduct(ConcreteProduct product) {
        products.add(product);
    }

    public void displayProductInformation(){
        for(ConcreteProduct product: products){
            System.out.println("Product ID: " + product.getProductId());
            System.out.println("Product Name: " + product.getName());
            System.out.println("Product Category: " + product.getCategory());
            System.out.println("Product Stock: " + product.getStock());
            System.out.println("Product Price: " + product.getPrice());
            System.out.println("---------------------------------");
        }
    }

}

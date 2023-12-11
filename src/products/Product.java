package products;

public interface Product {
    String getProductId();
    String getName();
    String getCategory();
    int getStock();
    double getPrice();
    void updateInformation(String name, String category, int stock, double price);

    void reduceStock(int quantity);

//    void reduceStock(int quantity);
}

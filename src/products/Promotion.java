package products;

public interface Promotion {
    int getPromotionId();
    double getDiscount();
    boolean isValid();
    void applyDiscount(Product product);
}

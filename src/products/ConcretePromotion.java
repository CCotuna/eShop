package products;

public class ConcretePromotion implements Promotion{
    private static int nextPromotionId = 1;

    private int promotionId;
    private double discount;
    private boolean isValid;
    public ConcretePromotion(double discount, boolean isValid) {
        this.promotionId = nextPromotionId++;
        this.discount = discount;
        this.isValid = isValid;
    }
    @Override
    public int getPromotionId() {
        return promotionId;
    }

    @Override
    public double getDiscount() {
        return discount;
    }

    @Override
    public boolean isValid() {
        return isValid;
    }

    @Override
    public void applyDiscount(Product product) {
        if (isValid()) {
            double discount = product.getPrice() * (1 - getDiscount());
            System.out.println("Discount applied: " + discount);
        }else {
            System.out.println("Discount not valid for product: " + product.getName() + " with id: " + product.getProductId());
        }
    }

    private static int getNextPromotionId(){
        return nextPromotionId++;
    }
}

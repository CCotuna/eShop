package cart;

import delivery.Delivery;

public class CartOrder {
    private int totalQuantity;
    private double totalPrice;
    private Delivery delivery;

    public CartOrder(int totalQuantity, double totalPrice, Delivery delivery) {
        this.totalQuantity = totalQuantity;
        this.totalPrice = totalPrice;
        this.delivery = delivery;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}

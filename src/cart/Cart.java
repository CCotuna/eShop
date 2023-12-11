package cart;

import clients.Client;
import delivery.Delivery;
import payment.LoanPayment;
import payment.Payment;
import products.ConcreteProduct;
import products.Product;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> items;
    public Cart(){
        this.items = new HashMap<>();
    }
    public void addItem(Product product, int quantity) {
        if(product.getStock() < quantity){
            System.out.println("Not enough stock for " + product.getName());
        } else {
            items.put(product, items.getOrDefault(product, 0) + quantity);
        }
    }
    public void removeItem(Product product, int quantity){
        int currentQuantity = items.getOrDefault(product, 0);
        if(currentQuantity - quantity > 0){
            items.put(product, currentQuantity - quantity);
        } else {
            items.remove(product);
        }
    }
    public void clearCart(){
        items.clear();
    }
    public void displayCart() {
        System.out.println("Shopping Cart Contents: ");
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            System.out.println("Product: " + entry.getKey().getName() + " Quantity: " + entry.getValue() + " Price(1 item): $" + entry.getKey().getPrice());
        }
        System.out.println("-------------------------");
    }

    public CartOrder CompleteOrder(Payment payment, Delivery delivery, Client client) {
        if (client.isOrdered() == true) {
            System.out.println("\nCompleting order...");
            int totalQuantity = 0;
            double totalPrice = 0.0;

            for (Map.Entry<Product, Integer> entry : items.entrySet()) {
                Product product = entry.getKey();
                int quantity = entry.getValue();

                totalQuantity += quantity;
                totalPrice += product.getPrice() * quantity;

                product.reduceStock(quantity);
            }
            payment.processPayment(totalPrice);
            System.out.println("Delivery type: " + delivery.getType());

            clearCart();

            System.out.println("Order completed successfully!\n");
            return new CartOrder(totalQuantity, totalPrice,delivery);
        } else {
            System.out.println("Client " + client.getName() + " has cancelled the order/ not ordered yet.");
            return null;
        }
    }
}

import cart.Cart;
import cart.CartOrder;
import clients.Client;
import commands.AddToCartCommand;
import delivery.Delivery;
import delivery.InStoreDelivery;
import delivery.LocationDelivery;
import payment.CardPayment;
import payment.CashPayment;
import payment.LoanPayment;
import payment.Payment;
import products.ConcreteProduct;
import products.ConcretePromotion;
import products.Product;
import products.Promotion;
import sellers.ConcreteSellerObserver;
import sellers.SellerManager;
import sellers.SellerObserver;

import java.util.ArrayList;

public class EShop {
    private static EShop instance;

    private EShop() {
    }

    public static EShop getInstance() {
        if (instance == null) {
            instance = new EShop();
        }
        return instance;
    }

    public void start() {
        System.out.println("Welcome to our EShop!");
    }

    public void run(){

        System.out.println("EShop is running... \n");

        AddToCartCommand addToCartCommand = new AddToCartCommand();

        Client client1 = new Client("1", "John");
        Client client2 = new Client("2", "Mary");
        Client client3 = new Client("3", "Peter");

        SellerManager sellerManager = new SellerManager("1", "Seller Manager");

        SellerObserver sellerObserver = new ConcreteSellerObserver("Observer-Seller Manager");
        sellerManager.addObserver(sellerObserver);

        Product laptop = new ConcreteProduct("1", "Laptop", "Electronics", 10, 2000.00);
        Product phone = new ConcreteProduct("2", "Phone", "Electronics", 20, 1000.00);
        Product tv = new ConcreteProduct("3", "TV", "Electronics", 30, 5000.00);
        Product book = new ConcreteProduct("4", "Book", "Books", 40, 100.00);

        Promotion promotion = new ConcretePromotion(0.1, true);

        sellerManager.addProduct(laptop);
        sellerManager.addProduct(phone);
        sellerManager.addProduct(tv);
        sellerManager.addProduct(book);
        sellerManager.configurePromotion(laptop, promotion);

        Payment cashPayment = new CashPayment();
        Payment loanPayment = new LoanPayment(12);
        Payment cardPayment = new CardPayment();

        Cart cart1 = new Cart();
        client1.setShoppingCart(cart1);
        addToCartCommand.execute(client1, laptop, 2);
        addToCartCommand.execute(client1, phone, 1);
        client1.addToFavoriteList(laptop);

        Cart cart2 = new Cart();
        client2.setShoppingCart(cart2);
        addToCartCommand.execute(client2, tv, 1);
        addToCartCommand.execute(client2, book, 2);
        client2.addToFavoriteList(tv);

        Cart cart3 = new Cart();
        client3.setShoppingCart(cart3);
        addToCartCommand.execute(client3, laptop, 8);
        addToCartCommand.execute(client3, phone, 4);
        addToCartCommand.execute(client3, tv, 9);

        System.out.println("Shopping Carts Before Orders: ");

        System.out.println("Client : " + client1.getName());
        client1.getShoppingCart().displayCart();

        System.out.println("Client : " + client2.getName());
        client2.getShoppingCart().displayCart();

        System.out.println("Client : " + client2.getName());
        client2.getShoppingCart().displayCart();

        client3.cancelOrder(client3.getShoppingCart());

        Delivery delivery1 = new LocationDelivery();
        Delivery delivery2 = new InStoreDelivery();

        CartOrder order1 = client1.getShoppingCart().CompleteOrder(loanPayment, delivery1, client1);
        CartOrder order2 = client2.getShoppingCart().CompleteOrder(cashPayment, delivery2, client2);
        CartOrder order3 = client3.getShoppingCart().CompleteOrder(cardPayment, delivery2, client3);

        System.out.println("\nOrders Completed: ");
        displayOrderDetails(client1, order1, delivery1, loanPayment);
        displayOrderDetails(client2, order2, delivery2, cashPayment);
        displayOrderDetails(client3, order3, delivery2, cashPayment);

        System.out.println("\nUpdated Stocks: ");

        displayProductStocks(sellerManager.getProducts());

    }

    private static void displayOrderDetails(Client client, CartOrder cart, Delivery delivery, Payment payment) {
        if(client.isOrdered() == true) {
            System.out.println("-------------------------");
            System.out.println("Order Details: ");
            System.out.println("Client: " + client.getName().toUpperCase());
            System.out.println("Delivery Type: " + delivery.getType());
            System.out.println("Payment Type: " + payment.getType());
            System.out.println("Total Price: " + cart.getTotalPrice());
            System.out.println("Total Quantity: " + cart.getTotalQuantity());
            System.out.println("-------------------------");
        } else {
            System.out.println("No order for " + client.getName());
        }
    }

    private static void displayProductStocks(ArrayList<Product> products) {
        for (Product product : products) {
            System.out.println("Product: " + product.getName() + " - Stock: " + product.getStock());
        }
    }

    public void stop(){
        System.out.println("Thank you for visiting our EShop!");
    }
}

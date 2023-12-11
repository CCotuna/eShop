package clients;

import cart.Cart;
import commands.Command;
import products.ConcreteProduct;
import products.Product;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Client {
    private String clientId;
    private String name;
    private Cart shoppingCart;
    private ArrayList<Product> favoriteList ;
    private boolean ordered;

    public Client(String clientId, String name) {
        this.clientId = clientId;
        this.name = name;
        this.shoppingCart = new Cart();
        this.favoriteList = new ArrayList<>();
        this.ordered = false;
    }

    public String getClientId() {
        return clientId;
    }

    public String getName() {
        return name;
    }

    public boolean isOrdered() {
        return ordered;
    }

    public void setOrdered(boolean ordered) {
        this.ordered = ordered;
    }

    public Cart getShoppingCart() {
        return this.shoppingCart;
    }
    public void setShoppingCart(Cart shoppingCart) {
        this.shoppingCart = shoppingCart;
        setOrdered(true);
    }
    public void getFavoriteList(Cart cart) {
        System.out.println("-------------------------");
        for (Product product : favoriteList) {
            System.out.println("Favorite product : " + product.getName());
        }
    }
    public void addToFavoriteList(Product product){
        favoriteList.add(product);
        System.out.println(product.getName() + " added to favorite list for " + this.name);
    }
    public void cancelOrder(Cart cart){
        cart.clearCart();
        setOrdered(false);
        System.out.println("Order cancelled by " + this.name);
    }

}

package commands;

import cart.Cart;
import clients.Client;
import products.Product;

public class RemoveFromCartCommand implements Command {

    private Client client;
    private Product product;
    private int quantity;

    public RemoveFromCartCommand(Client client, Product product, int quantity) {
        this.client = client;
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public void execute(Client client, Product product, int quantity) {
        client.getShoppingCart().removeItem(product, quantity);
    }
}

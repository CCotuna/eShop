package commands;


import clients.Client;
import products.Product;

public class AddToCartCommand implements Command {
    private Client client;
    private Product product;
    private int quantity;

    public AddToCartCommand(Client client, Product product, int quantity) {
        this.client = client;
        this.product = product;
        this.quantity = quantity;
    }

    public AddToCartCommand() {

    }

    @Override
    public void execute(Client client, Product product, int quantity) {
        client.getShoppingCart().addItem(product, quantity);
    }
}

package commands;

import clients.Client;
import products.Product;

public interface Command {
    void execute(Client client, Product product, int quantity);
}

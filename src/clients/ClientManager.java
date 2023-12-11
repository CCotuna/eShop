package clients;

import java.util.ArrayList;

public class ClientManager {
    private ArrayList<Client> clients;
    private ArrayList<ClientObserver> observers;

    public ClientManager() {
        this.clients = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public void registerClient(Client client) {
        clients.add(client);
        notifyObservers("Client registered: " + client.getName());
    }

    public void addObserver(ClientObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(ClientObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers(String message) {
        for (ClientObserver observer : observers) {
            observer.update(message);
        }
    }
}

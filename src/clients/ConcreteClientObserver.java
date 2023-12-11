package clients;

public class ConcreteClientObserver implements ClientObserver{
    private String observerId;

    public ConcreteClientObserver(String observerId){
        this.observerId = observerId;
    }

    @Override
    public void update(String message) {
        System.out.println("Observer " + observerId + " received message: " + message);
    }
}

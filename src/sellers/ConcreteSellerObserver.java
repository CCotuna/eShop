package sellers;

public class ConcreteSellerObserver implements SellerObserver{
    private String observerId;

    public ConcreteSellerObserver(String observerId){
        this.observerId = observerId;
    }
    @Override
    public void update(String message) {
        System.out.println("Observer " + observerId + " notified: " + message);
    }
}

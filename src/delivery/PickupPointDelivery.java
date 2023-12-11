package delivery;

public class PickupPointDelivery implements Delivery{

    private String type;

    public PickupPointDelivery(){
        this.type = "Pickup Point Delivery";
    }
    @Override
    public void DeliveryType() {
        System.out.println("Delivery type: " + type);
    }

    @Override
    public String getType() {
        return type;
    }
}

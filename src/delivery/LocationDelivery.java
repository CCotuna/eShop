package delivery;

public class LocationDelivery implements Delivery{

    private String type;

    public LocationDelivery(){
        this.type = "In Your Location Delivery";
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

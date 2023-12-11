package delivery;

public class InStoreDelivery implements Delivery{

    private String type;

    public InStoreDelivery(){
        this.type = "In Store Delivery";
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

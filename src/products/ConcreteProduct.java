package products;

public class ConcreteProduct implements Product {

    private String productId;
    private String name;
    private String category;
    private int stock;
    private double price;

    public ConcreteProduct(String productId, String name, String category, int stock, double price) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.stock = stock;
        this.price = price;
    }


    @Override
    public String getProductId() {
        return productId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public int getStock() {
        return stock;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void updateInformation(String name, String category, int stock, double price) {
        this.name =  name;
        this.category = category;
        this.stock = stock;
        this.price = price;
    }
    @Override
    public void reduceStock(int quantity) {
        if(quantity <= stock) {
            stock -= quantity;
            System.out.println("Stock reduced by " + quantity + " for " + name);
        } else {
            System.out.println("Not enough stock for " + name);
        }
    }
}

package payment;

public class CashPayment implements Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing cash payment of $" + amount);
    }

    @Override
    public String getType() {
        return "Cash Payment";
    }
}

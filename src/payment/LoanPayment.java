package payment;

public class LoanPayment implements Payment {
    private int numberOfMonths;

    public LoanPayment(int numberOfMonths) {
        this.numberOfMonths = numberOfMonths;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing loan payment of $" + amount + " over " + numberOfMonths + " months");
        System.out.println("$ / month : $" + amount / numberOfMonths);
    }
    public int getNumberOfMonths() {
        return numberOfMonths;
    }
    @Override
    public String getType() {
        return "Loan Payment";
    }
}

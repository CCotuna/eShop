public class Main {
    public static void main(String[] args) {
        EShop eShop = EShop.getInstance();

        eShop.start();
        eShop.run();
        eShop.stop();

    }
}
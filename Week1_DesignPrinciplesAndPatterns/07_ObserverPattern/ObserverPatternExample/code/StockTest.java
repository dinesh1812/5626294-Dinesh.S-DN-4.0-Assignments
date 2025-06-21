public class StockTest {
public static void main(String[] args) {
        StockMarket cognizantStock = new StockMarket("cognizant", 3500.00);

        Observer user1 = new MobileApp("Dinesh");
        Observer user2 = new WebApp(5626294);

        cognizantStock.register(user1);
        cognizantStock.register(user2);

        cognizantStock.updatePrice(3525.50);  // Notify both
        cognizantStock.deregister(user1);    // Remove MobileApp
        cognizantStock.updatePrice(3600.75); // Only WebApp gets update
    }
}

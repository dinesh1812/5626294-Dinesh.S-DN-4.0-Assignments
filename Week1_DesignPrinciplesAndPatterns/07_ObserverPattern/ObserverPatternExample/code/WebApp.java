public class WebApp implements Observer{
    private int userId;

    public WebApp(int userId){
        this.userId = userId;
    }

    @Override
    public void update(String stockName , double newPrice){
        System.out.println("Web App - "+ userId + ", The price of "+ stockName + " is now: Rs."+ newPrice);
    }
}

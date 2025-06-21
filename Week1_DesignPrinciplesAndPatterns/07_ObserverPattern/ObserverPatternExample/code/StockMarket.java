import java.util.*;

public class StockMarket implements Stock{
    private String stockName;
    private double stockPrice;
    private List <Observer> observers = new ArrayList<>();

    public StockMarket(String stockName , double stockPrice){
        this.stockName = stockName;
        this.stockPrice = stockPrice;
    }
    public double getStockPrice(){
        return stockPrice;
    }
    public String getStockName(){
        return stockName;
    }

    //Update Price
    public void updatePrice(double newPrice){
        System.out.println("Price updated for "+ stockName +" to Rs."+ newPrice);
        this.stockPrice = newPrice;
        notifyObservers();

    }

    // Register User
    @Override
    public void register(Observer observer){
        observers.add(observer);
    }

    //De-register User
    @Override
    public void deregister(Observer observer){
        observers.remove(observer);
    }

    //Notify users
    @Override
    public void notifyObservers(){
        for(Observer obs : observers){
            obs.update(stockName , stockPrice);
        }
    }

}

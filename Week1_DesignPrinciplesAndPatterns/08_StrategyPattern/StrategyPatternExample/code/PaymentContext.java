public class PaymentContext {
    private PaymentStrategy strategy;

    public PaymentContext(PaymentStrategy strategy){
        this.strategy = strategy;
    }

    public void executePayment(double amount){
        if(strategy == null || strategy.equals("")){
            System.out.println("No payment Mode selected.");
        }else{
            strategy.pay(amount);
        }
    }
}

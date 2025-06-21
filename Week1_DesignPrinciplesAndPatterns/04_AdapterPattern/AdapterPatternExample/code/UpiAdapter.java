public class UpiAdapter implements PaymentProcessor{
    private UpiGateway upi = new UpiGateway();

    @Override
    public void processPayment(double amount){
        upi.makePayment(amount);
    }
}

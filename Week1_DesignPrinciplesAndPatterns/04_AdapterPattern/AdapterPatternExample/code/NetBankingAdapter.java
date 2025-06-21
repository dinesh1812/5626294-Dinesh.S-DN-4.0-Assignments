public class NetBankingAdapter implements PaymentProcessor{
    private NetBankingGateway netBanking = new NetBankingGateway();

    @Override
    public void processPayment(double amount){
        netBanking.makePayment(amount);
    }
}

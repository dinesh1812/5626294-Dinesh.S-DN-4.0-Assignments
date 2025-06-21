public class PaymentAdapterTest {
    public static void main(String[] args) {
        PaymentProcessor netBankingProcessor = new NetBankingAdapter();
        PaymentProcessor upiProcessor = new UpiAdapter();

        netBankingProcessor.processPayment(2500.00);
        upiProcessor.processPayment(100000.00);
    }
}

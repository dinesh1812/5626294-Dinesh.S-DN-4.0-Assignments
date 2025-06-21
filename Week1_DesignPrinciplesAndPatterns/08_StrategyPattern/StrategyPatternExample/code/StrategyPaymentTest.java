public class StrategyPaymentTest {
    public static void main(String[] args) {
        
        PaymentContext credit = new PaymentContext(new CreditCardPayment(123456789));
        PaymentContext paypal = new PaymentContext(new PayPalPayment(987654321));

        // Credit Card payment
        credit.executePayment(1000.00);

        // PayPal Payment
        paypal.executePayment(20000.00);
    }
}

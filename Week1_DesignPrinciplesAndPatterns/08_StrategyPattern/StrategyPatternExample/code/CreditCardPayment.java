public class CreditCardPayment implements PaymentStrategy{
    private int creditCardNumber;

    public CreditCardPayment(int creditCardNumber){
        this.creditCardNumber = creditCardNumber;
    }

    @Override
    public void pay(double amount){
        System.out.println("Paying Rs."+ amount+" Using Credit Card: "+creditCardNumber);
    }
}

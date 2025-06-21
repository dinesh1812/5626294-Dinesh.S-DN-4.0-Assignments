public class PayPalPayment implements PaymentStrategy{
    private int accountNumber;

    public PayPalPayment(int accountNumber){
        this.accountNumber = accountNumber;
    }

    @Override
    public void pay(double amount){
        System.out.println("Paying Rs."+ amount + " Using Paypal Account No: "+ accountNumber);
    }
}

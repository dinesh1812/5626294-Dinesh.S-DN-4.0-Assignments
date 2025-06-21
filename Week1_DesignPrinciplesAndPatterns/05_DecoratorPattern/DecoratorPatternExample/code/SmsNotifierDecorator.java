public class SmsNotifierDecorator extends NotifierDecorator{
    public SmsNotifierDecorator(Notifier notifier){
        super(notifier);
    }

    @Override
    public void send(String message){
        super.send(message);
        sendSms(message);
    }
    public void sendSms(String message){
        System.out.println("Sms sent: "+ message);
    }
}

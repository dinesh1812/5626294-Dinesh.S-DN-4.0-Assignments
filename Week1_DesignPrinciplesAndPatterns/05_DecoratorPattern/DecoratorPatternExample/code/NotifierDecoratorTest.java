public class NotifierDecoratorTest {

    public static void main(String[] args) {
        Notifier email = new EmailNotifier();           //The base notifier
        NotifierDecorator smsAndEmail = new SmsNotifierDecorator(email);    // Decorates Email and send SMS
        NotifierDecorator slackAndSms = new SlackNotifierDecorator(smsAndEmail);    //Decorates the Email , SMS with Slack 

        slackAndSms.send("Welcome to Decorator Pattern");
    }

}

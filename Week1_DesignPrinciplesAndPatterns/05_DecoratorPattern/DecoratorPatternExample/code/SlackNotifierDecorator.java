public class SlackNotifierDecorator extends NotifierDecorator{
    
    public SlackNotifierDecorator(Notifier notifier){
        super(notifier);
    }

    @Override
    public void send(String message){
        super.send(message);
        sendSlack(message);
    }
    
    public void sendSlack(String message){
        System.out.println("Slack sent: "+ message);
    }

}

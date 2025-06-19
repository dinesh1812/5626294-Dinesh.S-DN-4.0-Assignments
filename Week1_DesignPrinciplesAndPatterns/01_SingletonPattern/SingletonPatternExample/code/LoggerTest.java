public class LoggerTest {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        if(logger1 == logger2){
            System.out.println("Both the instances are same. Singleton Works.");
        }else{
            System.out.println("Both the instances are different. Singleton Failed.");
        }
    }
}

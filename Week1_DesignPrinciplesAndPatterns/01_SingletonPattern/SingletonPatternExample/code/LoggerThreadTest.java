public class LoggerThreadTest {
    public static void main(String[] args) {
        Runnable task = () -> {
            Logger logger = Logger.getInstance();
            System.out.println("Logger Instance: "+ logger.hashCode());
        };
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
    }
}

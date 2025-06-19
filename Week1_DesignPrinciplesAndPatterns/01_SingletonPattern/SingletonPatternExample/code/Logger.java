public class Logger {
    private static volatile Logger instance;

    private Logger(){}

    public static Logger getInstance(){
        Logger localInstance = instance;
        if(localInstance == null){          //First Check
            synchronized(Logger.class){     // To allow Only a Single Thread
                if(localInstance == null){
                    localInstance = new Logger();
                }
                instance = localInstance;
            }
        }
        return localInstance;
    }

}
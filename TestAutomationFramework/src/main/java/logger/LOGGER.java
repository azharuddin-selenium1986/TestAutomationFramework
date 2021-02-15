package logger;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class LOGGER extends APPLICATION_LOGGER{
    protected static Logger logger ;

    private static Logger getlog(String classname) {
        LOGGER base_logger = new LOGGER();
        try {
            logger = base_logger.createLogger(classname);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return logger;
    }

    public static synchronized void logInfo(String classname,String message){
        getlog(classname).info(message);
    }
    public static synchronized void logWarning(String classname,String message){
        getlog(classname).warn(message);
    }

    public static synchronized void logFatal(String classname,String message){
        getlog(classname).fatal(message);
    }
    public static synchronized void logError(String classname,String message){
        getlog(classname).error(message);
    }
    public static synchronized void logError(String classname,String message,String exception){
        getlog(classname).error(message);
        getlog(classname).error(exception);
    }

    protected Logger createLogger(String classname) throws ClassNotFoundException {
        logger= LogManager.getLogger(classname);
        return logger;
    }
}

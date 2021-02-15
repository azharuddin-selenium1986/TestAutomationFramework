package logger;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

abstract class APPLICATION_LOGGER {


    protected abstract Logger createLogger(String classname) throws ClassNotFoundException;


}

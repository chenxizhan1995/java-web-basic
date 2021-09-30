package cc.xizhan.jdklog;

import java.util.logging.Logger;

/**
 * <p> Description: </p>
 */
public class LoggerDemo {
    private static Logger logger = Logger.getLogger(LoggerDemo.class.getCanonicalName());
    public static void main(String[] args) {
        logger.info("hello");
    }
}

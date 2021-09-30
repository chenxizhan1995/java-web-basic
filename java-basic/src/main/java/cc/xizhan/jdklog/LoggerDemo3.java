package cc.xizhan.jdklog;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <p> Description: 日志输出方法</p>
 */
public class LoggerDemo3 {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(LoggerDemo3.class.getCanonicalName());
        logger.log(Level.INFO, "hello, {} %s", "world");
    }
}

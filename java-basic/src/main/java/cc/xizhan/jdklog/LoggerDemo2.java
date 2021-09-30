package cc.xizhan.jdklog;

import java.util.logging.Logger;

/**
 * <p> Description: 获取Logger对象</p>
 */
public class LoggerDemo2 {
    public static void main(String[] args) {
        // 获取匿名logger对象
        {
            // Exception in thread "main" java.lang.NullPointerException
            // Logger logger = Logger.getLogger(null);

            Logger logger = Logger.getAnonymousLogger();
            Logger logger2 = Logger.getAnonymousLogger();
            System.out.println(logger == logger2);
            // false

        }

        // 获取常规 logger
        {
            Logger logger = Logger.getLogger("hello");
            Logger logger2 = Logger.getLogger("hello");
            System.out.println(logger == logger2);
            // true
        }
    }
}

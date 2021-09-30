package cc.xizhan.jdklog;

import java.util.logging.Level;

/**
 * <p> Description: JDKLog 的日志级别</p>
 */
public class LevelDemo {
    public static void main(String[] args) {
        System.out.println(Level.ALL);
        System.out.println(Level.ALL.intValue());
        System.out.println(Level.parse("ALL"));
        // 运行时异常：
        // Exception in thread "main" java.lang.IllegalArgumentException: Bad level "FOO"
        System.out.println(Level.parse("FOO"));
    }
}

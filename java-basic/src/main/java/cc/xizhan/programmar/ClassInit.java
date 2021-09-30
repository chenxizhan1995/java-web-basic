package cc.xizhan.programmar;

import java.sql.SQLOutput;

/**
 * <p> Description: 类的初始化</p>
 */
public class ClassInit {
    static int i = 3;
    static {
        System.out.println("i:" + i);
        // Illegal forward reference
        // System.out.println();("j:" + j);
        // Illegal forward reference
        // System.out.println();("k:" + k);
    }
    static int j = 3;
    static final int k = 4;
    static {
        System.out.println("i:" + i);
        System.out.println("j:" + j);
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }
}

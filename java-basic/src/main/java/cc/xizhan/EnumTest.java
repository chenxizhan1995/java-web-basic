package cc.xizhan;

/**
 * <p> Description: 枚举测试</p>
 */
public class EnumTest {
    enum Color { RED, GREEN, BLUE };

    public static void main(String[] args) {
        System.out.println("hello, enum");
        System.out.println(Color.valueOf("RED"));
        // 区分大小写吗？
        // 区分大小写：java.lang.IllegalArgumentException：No enum constant cc.xizhan.EnumTest.Color.red
        System.out.println(Color.valueOf("red"));
        // 找不到的，会如何？
        // 报错：。
        System.out.println(Color.valueOf("haha"));
        // 怎么判断给定字符串，在不在枚举中？
    }
}

package cc.xizhan;

/**
 * <p> Description: </p>
 */
public class BooleanDemo {
    public static void main(String[] args) {
        Boolean bool = Boolean.valueOf("false");
        System.out.println(Boolean.valueOf("false"));
        System.out.println(Boolean.valueOf("true"));
        System.out.println(Boolean.valueOf("hello")); // false
    }
}

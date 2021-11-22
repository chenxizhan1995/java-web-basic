/**
 * <p> Description: 字符串加法遇到null会怎样？ "hello" + null -> "hellonull" </p>
 */
public class StringPlus {
    public static void main(String[] args) {
        // -> nullhello
        System.out.println(null + "hello");
    }
}

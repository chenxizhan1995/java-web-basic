import java.util.ArrayList;
import java.util.List;

/**
 * <p> Description: </p>
 *
 * @author chenxizhan(2021 - 05 - 12 22 : 35)
 */
public class Hello {
    public <E> List<E> getList(){
        if (Math.random() > 9){
            return new ArrayList<>();
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
    public <E> List<E> selectList(String statement, Object parameter) {
        List var6;
        try {
            List<E> result = getList();
            var6 = result;
        } catch (Exception var10) {
            throw  var10;
        } finally {
            System.out.println("hello");
        }

        return var6;
    }

    public static void main(String[] args) {
        List<String> arr = new Hello().selectList("", "");
        System.out.println(arr);
    }
}

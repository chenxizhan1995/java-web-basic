package cc.xizhan.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> Description: </p>
 */
public class FlatMap {
    public static void main(String[] args) {
        // 构建两层嵌套List
        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            List<String> ls = new ArrayList<>();
            list.add(ls);
            for (int j = 0; j <7; j++) {
                ls.add(String.format("%d-%d", i, j));
            }
        }
        list.stream().flatMap(List::stream).forEach(System.out::println);
    }
}

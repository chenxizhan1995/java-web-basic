package cc.xizhan;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p> Description: </p>
 */
public class StreamFilter {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list);
        // -> [6, 7, 8, 9]
        System.out.println(list.stream().filter(v->v>5).collect(Collectors.toList()));
    }
}

package cc.xizhan;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> Description: Stream.limit(1) 保留几个元素？
 * Ans: 1 个</p>
 */
public class StreamLimit {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i + "");
        }
        System.out.println(list);

        list.stream().limit(2).forEach(System.out::println);
    }
}

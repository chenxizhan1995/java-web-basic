package cc.xizhan.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p> Description: </p>
 */
public class ToMap {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello".split(""));
        List<String> list2 = Arrays.asList("world".split(""));
        System.out.println(list);

        List<String> list3 = new ArrayList<>();
        list3.addAll(list);
        list3.addAll(list2);
        System.out.println(list3);

    }
}

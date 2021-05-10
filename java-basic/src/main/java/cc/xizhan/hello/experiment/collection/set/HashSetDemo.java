package cc.xizhan.hello.experiment.collection.set;

import java.util.HashSet;
import java.util.Set;

/**
 * <p> Description: 看HashSet是否支持RetainsAll</p>
 *

 * @author chenxizhan(2021 - 04 - 27 21 : 52)
 */
public class HashSetDemo {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);

        Set<Integer> set2 = new HashSet<>();
        set2.add(2);
        set2.add(3);

        System.out.println(set);
        System.out.println(set2);
        System.out.println(set.retainAll(set2));
        System.out.println(set);
    }
}

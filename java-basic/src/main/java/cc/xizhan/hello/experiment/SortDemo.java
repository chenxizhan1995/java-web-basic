package cc.xizhan.hello.experiment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <p> Description: </p>
 *
 * @author chenxizhan(2021 - 05 - 20 18 : 40)
 */
public class SortDemo {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> num = Arrays.asList(new Integer[]{1,4,2,3,5,7});
        System.out.println(num);
        Collections.sort(num, (a,b)->{
            if (a < b) return -1;
            if (a == b) return 0;
            return 1;
        });
        System.out.println(num);
        System.out.println("hello");
    }
}

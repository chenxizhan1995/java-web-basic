package cc.xizhan.hello.experiment.date;

import java.util.TimeZone;

/**
 * <p> Description: </p>
 *
 * @author chenxizhan(2021 - 06 - 24 9 : 16)
 */
public class TZDemo {
    public static void main(String[] args) {
        TimeZone tz = TimeZone.getDefault();
        System.out.println(tz.getID() + ":" + tz.getDisplayName());
    }
}

package cc.xizhan.hello.experiment.date;

import java.time.ZoneId;
import java.util.Date;

/**
 * <p> Description: </p>
 *
 * @author chenxizhan(2021 - 05 - 14 10 : 26)
 */
public class DateToLocalDate {
    public static void main(String[] args) {
        Date date = new Date();
        String start = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString();
        System.out.println(start);
    }
}

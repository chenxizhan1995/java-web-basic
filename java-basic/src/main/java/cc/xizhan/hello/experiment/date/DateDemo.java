package cc.xizhan.hello.experiment.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

/**
 * <p> Description: </p>
 *
 * @author chenxizhan(2021 - 04 - 26 15 : 36)
 */
public class DateDemo {

    //
    public void t01(){
        System.out.println(new java.util.Date());
    }

    private int diffDate(final Date date1, final Date date2) {
        if (date1 == null) return 9999; // 如果到期日期未空，则认为它距离到期很远很远。
        // 复制一份日期
        Date dt1 = new Date(date1.getTime());
        Date dt2 = new Date(date2.getTime());

        // 时分秒置为0
        dt1.setSeconds(0);
        dt1.setMinutes(0);
        dt1.setHours(0);
        dt2.setSeconds(0);
        dt2.setMinutes(0);
        dt2.setHours(0);
        // 计算两个日期相差的秒数,除以一天的秒数
        return (int) ((dt1.getTime() - dt2.getTime()) / (1000 * 24 * 3600)) + 1;
    }
    // Java 日期操作
    public static void main(String[] args) {
        DateDemo app = new DateDemo();
        System.out.println("hello");
        System.out.println(LocalDate.now());
        LocalDate dt1 = LocalDate.now();
        LocalDate dt2 = null;
        System.out.println(Period.between(dt1, dt2));
    }
}

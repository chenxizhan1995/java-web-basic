package cc.xizhan.hello.experiment.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

/**
 * <p> Description: </p>
 *
 * @author chenxizhan(2021 - 04 - 26 15 : 36)
 */
public class DateDemo {

    public void t01(){
        System.out.println(new java.util.Date());
    }


    // Java 日期操作
    public static void main(String[] args) {
        DateDemo app = new DateDemo();
        LocalDate start = LocalDate.of(2021, 1, 12);
        LocalDate end = LocalDate.of(2055,2,13);
        System.out.println(Period.between(start, end).getDays());
    }
}

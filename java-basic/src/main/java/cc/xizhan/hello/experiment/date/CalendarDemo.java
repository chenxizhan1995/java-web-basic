package cc.xizhan.hello.experiment.date;

import java.util.Calendar;
import java.util.Locale;

/**
 * <p> Description: </p>
 *
 *
 * @author chenxizhan(2021 - 05 - 01 9 : 41)
 */
public class CalendarDemo {

    public static void main(String[] args) {
        System.out.println("hello, world");
        // 获取代表当前时刻的日历对象，并把各个日历字段按当前本地设置设置好
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 20);
        System.out.println("可用的本地化设置：");
        for (Locale loc : Calendar.getAvailableLocales()){
            System.out.println(loc);
        }
        System.out.println("可用的日历系统");
        for (String s:Calendar.getAvailableCalendarTypes()){
            System.out.println(s);
        }
        System.out.println("当前日历系统：" + cal.getCalendarType());
    }
}

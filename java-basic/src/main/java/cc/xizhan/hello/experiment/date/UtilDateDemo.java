package cc.xizhan.hello.experiment.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

/**
 * <p> Description: java.util.Date的各种用法</p>
 *
 * @author chenxizhan(2021 - 04 - 26 16 : 15)
 */
public class UtilDateDemo {
    // 日期格式化
    public static String fmt(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }
    public void t01(){
        String method = Thread.currentThread().getStackTrace()[1].getMethodName();
        System.out.println(method);
        System.out.println("Date转为字符串，自带的方法");
        System.out.println("=====================================");
        Date now = new Date();
        System.out.println(now);
        System.out.println(now.toLocaleString());
        System.out.println(now.toGMTString());
        System.out.println(method + " done");
    }
    public void t02() {
        Date date = new Date(2021 - 1900, 03, 29);
        System.out.println(fmt(date));
    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        final UtilDateDemo demo = new UtilDateDemo();
        System.out.println(Locale.getDefault()); // zh_CN
        demo.t01();
    }

    // 计算两个日期相差的天数 date1 - date2
    // 比如 date1 = 20210304, date2 = 20210301, 那么 date1 - date2 = 3
    public int diffDate(final Date date1, final Date date2) {
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
        return (int) ((dt1.getTime() - dt2.getTime()) / (1000 * 24 * 3600));
    }
    /** 计算两个日期相差的天数 end - start，包括 start，不包括 end
     *
     * @param start
     * @param end
     * @return
     */
    public int between(final Date start, final Date end) {
        // [Java8 学习之计算日期相差天数_gj_sun的博客-CSDN博客](https://blog.csdn.net/gj_sun/article/details/53353446)
        if (start == null) return 9999; // 如果到期日期未空，则认为它距离到期很远很远。
         long epochDay1 = start.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toEpochDay();
         long epochDay2 = end.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toEpochDay();
        return (int)(epochDay2 - epochDay1);
    }
}

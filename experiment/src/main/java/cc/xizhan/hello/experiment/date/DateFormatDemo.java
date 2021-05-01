package cc.xizhan.hello.experiment.date;

import org.omg.Messaging.SyncScopeHelper;

import java.text.DateFormat;
import java.util.Date;

/**
 * <p> Description: </p>
 *
 * <p>Company:山东数飞信息科技有限公司</p>
 *
 * @author chenxizhan(2021 - 04 - 28 16 : 21)
 */
public class DateFormatDemo {
    public static void main(String[] args) {
        // format a date for the current Locale
        Date epoch = new Date(0);
        DateFormat fmt = DateFormat.getDateInstance();
        System.out.println(fmt.format(epoch)); // 1970-1-1

        // 换个格式
        DateFormat fmtLong = DateFormat.getDateInstance(DateFormat.LONG);
        System.out.println(fmt.format(epoch)); // 1970-1-1

        DateFormat fmt3 = DateFormat.getDateTimeInstance();
        System.out.println(fmt3.format(epoch));
    }
}

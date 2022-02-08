package cc.xizhan.demo.date;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * <p> Description: 时间格式化</p>
 */
public class DateFormat {
    /** java.text.SimpleDateFormat
     * 需要手动指定格式字符串，不会响应操作系统的locale设置。
     * 如果要日期格式自动响应操作系统的 locale 配置，使用 java.text.DateFormat.getInstance();
     * 根据实际需要选择。
     */
    public void test1(Date date){
        // 1970-01-01 08:00:00
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date));
        // 格式字符说明
        // https://docs.oracle.com/javase/8/docs/api/java/text/SimpleDateFormat.html
    }

    /**
     * java.util.Date 转 java.time.LocalDateTime
     */
    public void test2(){
        Date date = new Date();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        System.out.println(localDateTime);
    }
    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        String nowStr = now.format(format);
    }
}

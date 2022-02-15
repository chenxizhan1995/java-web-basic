package cc.xizhan.demo.date;

import java.time.LocalDate;
import java.util.Date;

/**
 * <p> Description: 获取 java.util.Date 对象的年份</p>
 */
public class GetYear {
    public void case1(){
        Date date = new Date();
        System.out.println(date.getYear() + 1900);
    }
    public void case2(){
        System.out.println(LocalDate.now().getYear());
    }
}

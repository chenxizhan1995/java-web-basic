package cc.xizhan.demo;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * <p> Description: 数字格式化</p>
 * DecimalFormat 是 NumberFormat 的一个具体子类
 * [DecimalFormat (Java Platform SE 8 )](https://docs.oracle.com/javase/8/docs/api/)
 * [DecimalFormat - 格式化数据 - 简书](https://www.jianshu.com/p/c1dec1796062)
 *
 * 0和#都是常用的占位符，但是他们俩还有些区别。
 *
 * 使用0占位符的时候：
 * 1、 比实际数字的位数多，不足的地方用0补上。
 * 2、 比实际数字的位数少：整数部分不改动，小数部分，四舍五入（其实并不是四舍五入，而是默认的RoundingMode.HALF_EVEN方式，下面会讲到DecimalFormat的舍入方式）。
 *
 * 使用#占位符的时候：
 * 1、 比实际数字的位数多，不变。
 * 2、 比实际数字的位数少：整数部分不改动，小数部分，四舍五入（其实并不是四舍五入，而是默认的RoundingMode.HALF_EVEN方式，下面会讲到DecimalFormat的舍入方式）。
 */
public class DecimalFormatDemo {

    public void demo1(){
        System.out.println("保留两位小数，小数保留两位，多了舍入，少了补零");
        format("#.00", "123.1");
        format("#.00", "123.1124");
        System.out.println("整数至少三位，不足的时候高位补零；小数保留两位，多了舍入，少了补零");
        format("000.00", "123.1");
        format("000.00", "23.1");

        System.out.println("只保留有效数字，最多保留两位小数，");
        format("#.##", "123.1");
        format("#.##", "123.111");

        System.out.println("添加千位分隔符");
        format("#,##0", "999999999");
        System.out.println("四位一分组");
        format("#,0000", "999999999");
    }
    public void format(String fmt, String num){
        BigDecimal dec = new BigDecimal(num);
        String s1 = new DecimalFormat(fmt).format(dec);
        System.out.println(String.format("%s\t: \t%s \t-> %s", num, fmt, s1));
    }
}

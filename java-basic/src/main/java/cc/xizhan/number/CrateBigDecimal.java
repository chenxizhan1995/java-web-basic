package cc.xizhan.number;

import java.math.BigDecimal;

/**
 * <p> Description: 含有逗号分隔符的字符串初始化大整数，会报错吗？</p>
 */
public class CrateBigDecimal {
    public static void main(String[] args) {
        String number = "1,234.00";
        BigDecimal num = new BigDecimal(number);
        System.out.println(number);
        System.out.println(num);
    }
}

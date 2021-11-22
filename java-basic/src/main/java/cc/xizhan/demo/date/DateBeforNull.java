package cc.xizhan;

import java.util.Date;

/**
 * <p> Description: Data.before(null)会怎样？
 * Ans: NPE</p>
 */
public class DateBeforNull {
    public static void main(String[] args) {
        Date now = new Date();
        // --> java.lang.NullPointerException
        System.out.println(now.before(null));
    }
}

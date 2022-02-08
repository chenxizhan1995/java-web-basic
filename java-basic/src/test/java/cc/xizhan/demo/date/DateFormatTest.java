package cc.xizhan.demo.date;

import junit.framework.TestCase;

import java.util.Date;

public class DateFormatTest extends TestCase {
    DateFormat dateFormat = new DateFormat();

    public void testTest1() {
        Date epoch = new Date(0);
        dateFormat.test1(epoch);
    }

    public void testTest2() {
    }
}

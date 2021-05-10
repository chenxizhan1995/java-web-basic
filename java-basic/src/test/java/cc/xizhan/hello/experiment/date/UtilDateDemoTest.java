package cc.xizhan.hello.experiment.date;

import org.junit.Test;
import org.junit.Assert;

import java.util.Date;

/**
 * <p> Description: </p>
 *
 * <p>Company:山东数飞信息科技有限公司</p>
 *
 * @author chenxizhan(2021 - 04 - 26 16 : 22)
 */
public class UtilDateDemoTest {
    @Test
    public void test1(){
        Date dt1 = new Date(2021, 3, 4);
        Date dt2 = new Date(2021, 3, 4);
        final UtilDateDemo demo = new UtilDateDemo();
        Assert.assertEquals(0, demo.diffDate(dt1, dt2));
    }
    @Test
    public void test2(){
        Date dt1 = new Date(2021, 3, 4);
        Date dt2 = new Date(2021, 3, 1);
        final UtilDateDemo demo = new UtilDateDemo();
        Assert.assertEquals(3, demo.diffDate(dt1, dt2));
    }
    @Test
    public void test3(){
        Date dt1 = new Date(2021, 3, 4);
        Date dt2 = new Date(2021, 3, 5);
        final UtilDateDemo demo = new UtilDateDemo();
        Assert.assertEquals(-1, demo.diffDate(dt1, dt2));
    }
    @Test
    public void test4(){
        Date dt1 = new Date(2021, 4, 4);
        Date dt2 = new Date(2021, 4, 1);
        final UtilDateDemo demo = new UtilDateDemo();
        Assert.assertEquals(3, demo.diffDate(dt1, dt2));
    }
    @Test
    public void test5(){
        Date dt1 = new Date(2021-1900, 4-1, 4);
        Date dt2 = new Date(2021-1900, 3-1, 31);
        System.out.println(dt1);
        System.out.println(dt2);
        final UtilDateDemo demo = new UtilDateDemo();
        Assert.assertEquals(4, demo.diffDate(dt1, dt2));
    }
    @Test
    public void test6(){
        Date dt1 = new Date(2021-1900, 4-1, 4);
        Date dt2 = new Date(2021-1900, 3-1, 5);
        System.out.println(dt1);
        System.out.println(dt2);
        final UtilDateDemo demo = new UtilDateDemo();
        Assert.assertEquals(30, demo.diffDate(dt1, dt2));
    }
//    @Test
//    public void test3(){
//        Date dt1 = new Date(2021, 3, 4);
//        Date dt2 = new Date(2021, 3, 1);
//        final UtilDateDemo demo = new UtilDateDemo();
//        Assert.assertEquals(1, demo.diffDate(dt1, dt2));
//    }
}

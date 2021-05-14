package cc.xizhan.hello.experiment.date;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * <p> Description: </p>
 *
 * <p>Company:山东数飞信息科技有限公司</p>
 *
 * @author chenxizhan(2021 - 04 - 26 16 : 22)
 */
public class UtilDateDemoDiffDate2Test {
    @Test
    public void test1(){
        Date dt1 = new Date(2021, 3, 4);
        Date dt2 = new Date(2021, 3, 4);
        final UtilDateDemo demo = new UtilDateDemo();
        Assert.assertEquals(0, demo.between(dt2, dt1));
    }
    @Test
    public void test2(){
        Date dt1 = new Date(2021, 3, 4);
        Date dt2 = new Date(2021, 3, 1);
        final UtilDateDemo demo = new UtilDateDemo();
        Assert.assertEquals(3, demo.between(dt2, dt1));
    }
    @Test
    public void test3(){
        Date dt1 = new Date(2021, 3, 4);
        Date dt2 = new Date(2021, 3, 5);
        final UtilDateDemo demo = new UtilDateDemo();
        Assert.assertEquals(-1, demo.between(dt2, dt1));
    }
    @Test
    public void test4(){
        Date dt1 = new Date(2021, 4, 4);
        Date dt2 = new Date(2021, 4, 1);
        final UtilDateDemo demo = new UtilDateDemo();
        Assert.assertEquals(3, demo.between(dt2, dt1));
    }
    @Test
    public void test5(){
        Date dt1 = new Date(2021-1900, 4-1, 4);
        Date dt2 = new Date(2021-1900, 3-1, 31);
        System.out.println(dt1);
        System.out.println(dt1);
        final UtilDateDemo demo = new UtilDateDemo();
        Assert.assertEquals(4, demo.between(dt2, dt1));
    }
    @Test
    public void test6(){
        Date dt1 = new Date(2021-1900, 4-1, 4);
        Date dt2 = new Date(2021-1900, 3-1, 5);
        System.out.println(dt1);
        System.out.println(dt1);
        final UtilDateDemo demo = new UtilDateDemo();
        Assert.assertEquals(30, demo.between(dt2, dt1));
    }
    @Test
    public void test7(){
        Date dt1 = new Date(2021-1900, 4-1, 4);
        Date dt2 = new Date(2022-1900, 4-1, 4);

        final UtilDateDemo demo = new UtilDateDemo();
        Assert.assertEquals(365, demo.between(dt1, dt2));
    }
//    @Test
//    public void test3(){
//        Date dt1 = new Date(2021, 3, 4);
//        Date dt2 = new Date(2021, 3, 1);
//        final UtilDateDemo demo = new UtilDateDemo();
//        Assert.assertEquals(1, demo.diffDate2(dt2, dt1));
//    }
}

package cc.xizhan.hello;

import org.hamcrest.core.IsSame;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * <p> Description: </p>
 *
 * @author chenxizhan(2021 - 05 - 17 9 : 19)
 */
public class IdStyleTest {
    private IdStyle demo;
    @Before
    public void setUp(){
        this.demo = new IdStyle();
    }
    @Test
    public void test1(){
        Assert.assertEquals("cus_name", demo.camelToHyphen("cusName"));
    }

    @Test
    public void test2(){
        Assert.assertEquals("cusName", demo.hyphenToCamel("cus_name"));
    }
    @Test
    public void test3(){
        Assert.assertEquals("getCustName", demo.hyphenToCamel("get_cust_name"));
    }
}

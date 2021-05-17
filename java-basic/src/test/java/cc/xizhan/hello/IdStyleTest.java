package cc.xizhan.hello;

import org.hamcrest.core.IsSame;
import org.junit.Assert;
import org.junit.Test;

/**
 * <p> Description: </p>
 *
 * @author chenxizhan(2021 - 05 - 17 9 : 19)
 */
public class IdStyleTest {

    @Test
    public void test1(){
        IdStyle demo = new IdStyle();
        Assert.assertEquals("cus_name", demo.camelCaseToNDashCase("cusName"));
    }

    @Test
    public void test2(){
        IdStyle demo = new IdStyle();
        Assert.assertEquals("cusName", demo.nDashCaseToCamelCase("cus_name"));
    }
    @Test
    public void test3(){
        IdStyle demo = new IdStyle();
        Assert.assertEquals("getCustName", demo.nDashCaseToCamelCase("get_cust_name"));

    }
}

package cc.xizhan;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p> Description: </p>
 *
 * @author chenxizhan(2021 - 05 - 24 11 : 50)
 */
public class URLParamDemo{
    public void demo1(){
        String str = "result=28&Description=发送内容与模板不符&xxx";
        Pattern ptn = Pattern.compile("(?<=description=)([^&]*)", Pattern.CASE_INSENSITIVE);
        Matcher match = ptn.matcher(str);

        if (match.find()){
            String des = match.group();
            System.out.println(des);
        }
        System.out.println("demo1 End");
    }
    public static void main(String[] args) {
        System.out.println("hello");
        URLParamDemo demo = new URLParamDemo();
        demo.demo1();
    }
}

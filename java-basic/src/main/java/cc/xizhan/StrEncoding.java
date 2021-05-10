package cc.xizhan;

import java.nio.charset.Charset;
import java.util.logging.Logger;

public class StrEncoding{

    public static void main(String[] args){
        // 查看系统编码
        System.out.println(System.getProperty("file.encoding"));
        System.out.println(Charset.defaultCharset());

        String s1 = "hello,中国";
        System.out.println(s1);
        Logger log = Logger.getLogger(StrEncoding.class.getName());
        log.info(s1);
    }
}

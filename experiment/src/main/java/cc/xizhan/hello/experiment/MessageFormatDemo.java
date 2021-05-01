package cc.xizhan.hello.experiment;

import java.text.MessageFormat;

/**
 * <p> Description: </p>
 *
 * <p>Company:山东数飞信息科技有限公司</p>
 *
 * @author chenxizhan(2021 - 04 - 28 16 : 15)
 */
public class MessageFormatDemo {
    public static void main(String[] args) {
        String pattern = "尊敬的客户 {0}, 您的 {1} 请及时更新";
        String message = MessageFormat.format(pattern, "a", "b");
        System.out.println(message);
    }
}

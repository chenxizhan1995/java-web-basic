package cc.xizhan.fastjsondemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;

import java.sql.SQLOutput;

/**
 * <p> Description: 获取json中的指定属性</p>
 */
public class Demo2 {
    public static void main(String[] args) {
        String text = "{\"discount\": {\"openid\": \"6107594b84aeb31a6e8ecc92\"}}";
        System.out.println("json text:" + text);

        JSONObject obj = JSON.parseObject(text);
        System.out.println(obj.getJSONObject("discount").getString("openid"));

        // 通过jsonPath
        // 6107594b84aeb31a6e8ecc92
        System.out.println(JSONPath.eval(obj, "$.discount.openid"));
        // null
        System.out.println(JSONPath.eval(obj, "$.discountx.openid"));
        // null
        System.out.println(JSONPath.eval(obj, "$.discountx.openid2"));

    }
}

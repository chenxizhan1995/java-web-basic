package cc.xizhan.fastjsondemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * <p> Description: fastjson 示例</p>
 *
 * JSON.parseObject(null) 会抛出异常吗？ 不会，直接返回 null
 * 类似还有
 * JSON.parseObject("") --》 null
 * JSON.parseObject("{ha")  --> com.alibaba.fastjson.JSONException
 */
public class Demo1 {

    public static void main(String[] args) {
        JSONObject obj = JSON.parseObject(null);
        System.out.println(obj);
        System.out.println(JSON.parseObject(""));
        // java.lang.ClassCastException:
        // com.alibaba.fastjson.JSONArray cannot be cast to com.alibaba.fastjson.JSONObject
        // System.out.println(JSON.parseObject("[]"));

        // com.alibaba.fastjson.JSONException
        JSONObject obj2 = JSON.parseObject("{he");
    }
}

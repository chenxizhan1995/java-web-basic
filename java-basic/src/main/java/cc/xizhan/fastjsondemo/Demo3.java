package cc.xizhan.fastjsondemo;

import com.alibaba.fastjson.JSONObject;

/**
 * <p> Description: 对不存在的属性调用 getBoolean() 会抛出异常吗？</p>
 */
public class Demo3 {
    public static void main(String[] args) {
        String jsonStr = "{\"foo\":\"hello\", \"success\":true}";
        JSONObject json = JSONObject.parseObject(jsonStr);
        // -> false
        System.out.println(json.getBooleanValue("hello"));

        // -> com.alibaba.fastjson.JSONException: can not cast to boolean, value : hello
        // System.out.println(json.getBoolean("foo"));

        // -> com.alibaba.fastjson.JSONException
        // System.out.println(json.getBooleanValue("foo"));

        System.out.println(json.getString("success"));
        System.out.println("true".equals(json.getString("success")));
    }
}

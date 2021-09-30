package cc.xizhan.fastjsondemo;

import com.alibaba.fastjson.JSONObject;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * <p> Description: JSONObject.getXxx() 方法当key不存在、当key类型不对的时候</p>
 */
public class Demo4Get {
    String readText(String file){
        StringBuilder sb = new StringBuilder();
        try{
            Path path = Paths.get(getClass().getClassLoader().getResource(file).toURI());
            Files.lines(path).forEachOrdered(v->sb.append(v).append("\n"));
        } catch (Exception e){
            return null;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Demo4Get app = new Demo4Get();
        String jsonStr = app.readText("demo4.json");
        System.out.println(jsonStr);

        JSONObject json = JSONObject.parseObject(jsonStr);
        // 以适合人类阅读的方式输出（即有缩进）
        String pretty = JSONObject.toJSONString(json, true);

        // 获取不存在的key会抛出异常吗？
        // Ans: 不会。这时会返回 null
        System.out.println(json.get("hello"));
        // 类型不匹配但可兼容会怎样？
        // Ans：比如，把整数当作字符串读取，会正常返回字符串格式
        System.out.println(json.getString("age"));
        // 返回字符串
        System.out.println(json.getString("json"));
    }
}

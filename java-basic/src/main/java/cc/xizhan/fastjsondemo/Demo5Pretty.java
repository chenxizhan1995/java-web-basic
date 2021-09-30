package cc.xizhan.fastjsondemo;

import com.alibaba.fastjson.JSONObject;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * <p> Description: </p>
 */
public class Demo5Pretty {
    String readText(String file) {
        StringBuilder sb = new StringBuilder();
        try {
            Path path = Paths.get(getClass().getClassLoader().getResource(file).toURI());
            Files.lines(path).forEachOrdered(v -> sb.append(v).append("\n"));
        } catch (Exception e) {
            return null;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Demo4Get app = new Demo4Get();
        String jsonStr = app.readText("demo4.json");
        JSONObject json = JSONObject.parseObject(jsonStr);
        // 以适合人类阅读的方式输出（即有缩进）
        String pretty = JSONObject.toJSONString(json, true);
        System.out.println(pretty);
        // 默认不进行缩进，程序之间交互时使用这种格式是合适的
        System.out.println(json.toJSONString());
    }
}

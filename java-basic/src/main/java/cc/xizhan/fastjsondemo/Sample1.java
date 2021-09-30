package cc.xizhan.fastjsondemo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

/**
 * <p> Description: 实战，云之家审批流提取回调数据</p>
 */
public class Sample1 {
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
    // 解析applyDate（申请日期）字段
    public void applyDate(){
        Sample1 app = new Sample1();
        String jsonStr = app.readText("amount-change.json");
        JSONObject json = JSONObject.parseObject(jsonStr);
        Object obj = JSONPath.eval(json,"$.data.formInfo.widgetMap._S_DATE.value");
        System.out.println(obj);
        System.out.println(obj.getClass());
        System.out.println(new Date((Long)obj));
    }
    // JSONPath.eval() 到的
    public void jsonObj(){
        Sample1 app = new Sample1();
        String jsonStr = app.readText("amount-change.json");
        JSONObject json = JSONObject.parseObject(jsonStr);
        Object obj = JSONPath.eval(json,"$.data.formInfo.widgetMap");
        System.out.println(obj.getClass());

    }
    // 解析单选框组件
    public void parseRadio(){
        String jsonStr = readText("amount-change.json");
        JSONObject json = JSONObject.parseObject(jsonStr);
        JSONObject radio = (JSONObject) JSONPath.eval(json, "$.data.formInfo.widgetMap.Ra_0");

        System.out.println(JSONObject.toJSONString(radio, true));

        JSONArray options = radio.getJSONArray("options");
        options.forEach(v->{
            System.out.println(v.getClass());
        });

    }
    public void load(){
        String jsonStr = readText("amount-change.json");
        JSONObject json = JSONObject.parseObject(jsonStr);

        CloudWhiteListForm form = CloudWhiteListForm.loadFromJSON(json);
        System.out.println(JSONObject.toJSONString(form, true));
        System.out.println("done");

        form.getDetail().forEach(v->v.setCheckStatus("校验通过"));

        System.out.println(JSONObject.toJSONString(form.toDetailJson(), true));
    }
    public static void main(String[] args) {
        Sample1 app = new Sample1();

        app.load();
    }
}

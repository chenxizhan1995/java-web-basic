package cc.xizhan.demo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

/**
 * <p> Description: Jackson 读取指定字段</p>
 */
public class Demo1 {

    private String text;
    private ObjectMapper objectMapper;
    private JsonNode root;
    @Before
    public void setup() throws IOException {
        try (
                InputStream in = this.getClass().getClassLoader().getResourceAsStream("demo1.json");
                BufferedReader reader = new BufferedReader(new InputStreamReader(in))
                ){
            String line = reader.readLine();
            StringBuilder sb = new StringBuilder();
            while (line != null){
                sb.append(line).append("\n");
                line = reader.readLine();
            }
            text = sb.toString();
        } catch (IOException e){
            System.out.println(e);
        }
        objectMapper = new ObjectMapper();
        root = objectMapper.readTree(text);
    }
    @Test
    public void hello() throws IOException {
        System.out.println(root.get("success").asBoolean());
        System.out.println(root.get("success").asText());
    }

    @Test
    public void world() throws IOException {
    }
}

import java.io.*;

public class ResourcePath {
    public static void main(String[] args) throws IOException {
        String jarPath = ResourcePath.class.getClassLoader().getResource("data.txt").getPath();
        System.out.println(jarPath);
        String jsonPath = ResourcePath.class.getClassLoader().getResource("request.json").getPath();
        InputStream jsonIs = ResourcePath.class.getClassLoader().getResourceAsStream("request.json");
        InputStreamReader reader = new InputStreamReader(jsonIs, "UTF-8");
        char[] buf = new char[102400];
        int cnt = reader.read(buf, 0, 102400);
        System.out.println("cnt:" + cnt);
        String json = new String(buf, 0, cnt);
        System.out.println(json);

    }
}

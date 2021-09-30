package cc.xizhan.alg;

/**
 * <p> Description: </p>
 */
public class LRUCacheDemo {
    public static void main(String[] args) {
        LRUCache<String, String> cache = new LRUCache<>(3);

        cache.put("hello1", "world1");
        cache.put("hello2", "world2");
        cache.put("hello3", "world3");
        System.out.println(cache.get("hello1"));    // world1
        cache.put("hello4", "world4");      // 会替换掉 hello2
        System.out.println(cache.get("hello2"));    // 返回 null
        System.out.println(cache.get("hello4"));    // world4
    }
}

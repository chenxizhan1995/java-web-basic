package cc.xizhan.alg;

import java.util.HashMap;
import java.util.Map;

/**
 * <p> Description: 最近最少使用缓存（LRU）缓存。简单实现</p>
 * <p>
 * 线程安全。
 *
 * TODO：超过一定时间不使用，自动清空缓存。
 *
 * @author chenxizhan(2021-08-13)
 */
public class LRUCache<K, V> {
    public LRUCache() {
        this(16);
    }

    public LRUCache(int cacheSize) {
        if (cacheSize <= 0) {
            throw new IllegalArgumentException("Illegal cache size" + cacheSize);
        }
        if (cacheSize > MAXIMUM_CAPACITY) cacheSize = MAXIMUM_CAPACITY;

        this.cacheSize = cacheSize;
        int initCapacity = (int) ((cacheSize) / 0.75f + 0.5);
        this.cache = new HashMap<>(initCapacity);
        initLinkedList();
    }

    /**
     * 新增缓存条目。
     * <p>
     * 将节点加入头节点。如果缓存已满，删除尾节点。
     */
    public synchronized void put(K key, V val) {
        Node<K, V> node = cache.get(key);

        if (node != null) {
            // 已存在相同 key 的缓存，更新对应的 val并移动到头节点
            node.val = val;
            moveToHead(node);
            return;
        }

        // 不存在相同key的缓存，放入头节点
        Node<K, V> newNode = new Node<K, V>(key, val);
        cache.put(key, newNode);
        addNodeToHead(newNode);

        // 如果缓存已满（放入新节点后超出缓存容量）
        if (cache.size() > cacheSize) {
            Node<K, V> lastNode = tail.pre;
            cache.remove(lastNode.key);
            deleteNode(lastNode);
        }
    }

    /**
     * 读取缓存.
     * <p>
     * 如果节点不存在，返回null，如果节点存在，将节点移动到头节点，并返回节点的数据。
     *
     * @param key
     * @return 缓存项，如果不存在，则返回null。
     */
    public synchronized V get(K key) {
        Node<K, V> node = cache.get(key);
        if (node == null) {
            return null;
        }
        moveToHead(node);
        return node.val;
    }

    /**
     * 查询缓存容量
     *
     * @return cacheSize
     */
    public int getCacheSize() {
        return this.cacheSize;
    }

    /** 查询缓存数量
     *
     * @return 缓存数量
     */
    public int size(){
        return cache.size();
    }
    /*
     * The maximum capacity, used if a higher value is implicitly specified
     * by either of the constructors with arguments.
     */
    static final int MAXIMUM_CAPACITY = 1 << 30;

    private int cacheSize;
    private Map<K, Node<K, V>> cache;

    private static class Node<K, V> {
        K key;
        V val;
        Node<K, V> pre, next;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }

        public Node() {
        }
    }

    // 设置两个哨兵节点，不需要考虑边界问题，降低编程复杂度
    private Node<K, V> head, tail;

    private void initLinkedList() {
        head = new Node<>();
        tail = new Node<>();
        head.next = tail;
        tail.pre = head;
    }

    private void addNodeToHead(Node<K, V> node) {
        head.next.pre = node;
        node.next = head.next;

        head.next = node;
        node.pre = head;
    }

    /**
     * 删除除了头尾节点之外的节点。
     * @param node 要删除的节点。
     */
    private void deleteNode(Node<K, V> node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void moveToHead(Node<K, V> node) {
        if (node != head.next) {
            // 不是头节点，不需要移动
            deleteNode(node);
            addNodeToHead(node);
        }
    }
}

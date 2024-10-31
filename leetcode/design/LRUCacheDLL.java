package leetcode.design;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheDLL {

    static class Node {
        int key;
        int value;
        Node next, prev;

        Node (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, Node> cache;
    private final int capacity;
    private final Node head;
    private final Node tail;


    public LRUCacheDLL(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            addToHead(node);
            return node.value;
        }
        return -1;
    }

    private void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            cache.remove(node.key);
        }

        Node node = new Node(key, value);
        addToHead(node);
        cache.put(key, node);

        if (cache.size() > capacity) {
            Node lru = tail.prev;
            remove(lru);
            cache.remove(lru.key);
        }
    }

    public static void main(String[] args) {
        // Create an LRUCache with capacity 2
        LRUCacheDLL lruCache = new LRUCacheDLL(2);

        // Test putting some values
        lruCache.put(1, 1);
        lruCache.put(2, 2);

        // Test getting a value
        System.out.println("Get key 1: " + lruCache.get(1)); // Expected output: 1

        // Adding another key-value pair should evict key 2
        lruCache.put(3, 3);
        System.out.println("Get key 2: " + lruCache.get(2)); // Expected output: -1 (evicted)

        // Add another key-value pair; this should evict key 1
        lruCache.put(4, 4);
        System.out.println("Get key 1: " + lruCache.get(1)); // Expected output: -1 (evicted)

        // The cache should now contain keys 3 and 4
        System.out.println("Get key 3: " + lruCache.get(3)); // Expected output: 3
        System.out.println("Get key 4: " + lruCache.get(4)); // Expected output: 4
    }
}

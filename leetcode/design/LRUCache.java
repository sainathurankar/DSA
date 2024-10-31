package leetcode.design;

import java.util.*;

public class LRUCache {
    Deque<Integer> deque;
    Map<Integer, Integer> map;
    int capacity;

    LRUCache () {
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        deque = new LinkedList<>();
        map = new HashMap<>();
    }

    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }

        deque.remove(key);
        deque.addLast(key);
        return map.get(key);
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            map.remove(key);
            deque.remove(key);
        }

        map.put(key, value);
        deque.addLast(key);
        if (deque.size() > capacity) {
            int removed = deque.removeFirst();
            map.remove(removed);
        }
    }
}

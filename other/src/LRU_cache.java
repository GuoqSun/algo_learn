import java.util.HashMap;
import java.util.Map;

public class LRU_cache {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        System.out.println(cache.cache.toString());
        cache.put(2,2);
        System.out.println(cache.cache.toString());
        cache.get(1);
        System.out.println(cache.cache.toString());
        cache.put(3,3);
        System.out.println(cache.cache.toString());
        cache.get(2);
        cache.put(4,4);
        System.out.println(cache.cache.toString());
        cache.get(1);
        cache.get(3);
        cache.get(4);
    }

}

class LRUCache {
    class DLinkNode {
        int key;
        int value;
        DLinkNode prev;
        DLinkNode next;

        public DLinkNode() {
        }

        public DLinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer, DLinkNode> cache = new HashMap<>();
    int size;
    int capacity;
    DLinkNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new DLinkNode();
        tail = new DLinkNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkNode node = cache.get(key);
        if (node == null) return -1;
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkNode node = cache.get(key);
        if (node == null) {
            DLinkNode newNode = new DLinkNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            size++;
            if (size > capacity) {
                DLinkNode removed = removeTail();
                cache.remove(removed.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }

    }

    private DLinkNode removeTail() {
        DLinkNode node = tail.prev;
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return node;
    }

    private void moveToHead(DLinkNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        addToHead(node);
    }

    private void addToHead(DLinkNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

}

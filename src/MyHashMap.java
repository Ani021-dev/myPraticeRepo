package src;

public class MyHashMap<K, V> {
    public static final int INITIAL_SIZE = 1 << 4; //16
    public static final int MAX_SIZE = 1 << 30; //int == 32 bit and -2 ^ 31 to 2 ^31 - 1 so 2 ^ 30 will be max length

    Entry[] hashtable;

    public MyHashMap() {
        hashtable = new Entry[INITIAL_SIZE];
    }

    public MyHashMap(int cap) {
        int tableSize = this.tableSizeFor(cap);
        hashtable = new Entry[tableSize];
    }

    public int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 0 : (n >= MAX_SIZE) ? MAX_SIZE : n + 1;
    }

    static class Entry<K, V> {
        K key;
        V value;
        Entry next;

        Entry(K k, V v) {
            this.key = k;
            this.value = v;
        }
    }

    public void put(K key, V value) {
        int hashCode = key.hashCode() % hashtable.length;
        Entry node = hashtable[hashCode];

        if (node == null) {
            Entry newNode = new Entry<>(key, value);
            hashtable[hashCode] = newNode;
        } else {
            Entry preNode = node;
            while (node != null) {
                if (node.key == key) {
                    node.value = value;
                    return;
                }
                preNode = node;
                node = node.next;
            }
            Entry newNode = new Entry(key, value);
            preNode.next = newNode;
        }
    }

    public V get(K key) {
        int hasCode = key.hashCode() % hashtable.length;
        Entry node = hashtable[hasCode];
        while (node != null) {
            if (node.key == key) {
                return (V) node.value;
            }
            node = node.next;
        }
        return null;
    }

    public static void main(String[] args) {
        MyHashMap<Integer, String> map = new MyHashMap<>();
        map.put(0, "Anivesh");
        map.put(1, "Kumar");
        map.put(2, "Tiwari");

        System.out.println(map.get(0));
    }
}
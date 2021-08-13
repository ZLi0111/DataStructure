package HashMap;

/**
 * A hashtable implementation of map, demonstration purpose, generic type is provided
 *
 * supported operations:
 * size()
 * isEmpty()
 * clear()
 * put(K key, V value)
 * get(K key)
 * containsKey(K key)
 * remove(K key)
 *
 * 1. use case -> api(public methods)
 * 2. data -> input / output / field -> data structure -> constructor
 * 3. implementation
 *
 */
public class MyHashMap {
    Entry[] array;
    int size;
    MyHashMap(int size) {
        array = new Entry[size];
    }
    MyHashMap() {
        this(16);
    }
    private static float LOAD_FACTOR = 0.75f;
    class Entry {
        final String key;
        Integer value;
        Entry next;

        Entry (String key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }
    public Integer put(String key, Integer value) {
        if (size > array.length * LOAD_FACTOR) {
            rehash();
        }
        int hash = hash(key);
        int index = hash % array.length;
        Entry head = array[index];
        while (head != null) {
            if (head.key.equals(key)) {
                Integer preVal = head.value;
                head.value = value;
                return preVal;
            }
            head = head.next;
        }
        Entry newEntry = new Entry(key, value);
        newEntry.next = array[index];
        array[index] = newEntry;
        size++;
        return null;
    }

    public Integer get(String key) {
        int hash = hash(key);
        int index = hash % array.length;
        Entry head = array[index];
        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public Integer remove(String key) {
        int hash = hash(key);
        int index = hash % array.length;
        Entry head = array[index];
        Entry pre = null;
        while (head != null) {
            if (head.key.equals(key)) {
                if (pre == null) {
                    array[index] = head.next;
                } else {
                    pre.next = head.next;
                }
                head.next = null;
                size--;
                return head.value;
            }
            pre = head;
            head = head.next;
        }
        return null;
    }

    public int size() {
        return size;
    }

    private void rehash() {
        Entry[] newArray = new Entry[array.length * 2 + 1];
        for (Entry entry : array) {
            Entry head = entry;
            while (head != null) {
                Entry next = head.next;
                int hash = hash(head.key);
                int index = hash % newArray.length;
                head.next = newArray[index];
                newArray[index] = head;
                head = next;
            }
        }
        array = newArray;
    }

    private int hash(String key) {
        if (key == null) return 0;
        int hashNumber = key.hashCode();
        return Math.abs(hashNumber);
    }
}

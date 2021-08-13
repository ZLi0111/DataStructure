package HashMap;

import org.junit.Test;
import static org.junit.Assert.*;

public class MyHashMapTest {

    @Test
    public void testAdd() {
        MyHashMap map = new MyHashMap();
        map.put("john", 1);
        map.put("lee", 2);
        assertEquals(map.size(), 2);
    }

    @Test
    public void testGet() {
        MyHashMap map = new MyHashMap();
        map.put("john", 1);
        map.put("j", 2);
        map.put("o", 3);
        assertEquals(map.get("john").intValue(), 1);
        assertEquals(map.get("j").intValue(), 2);
        assertEquals(map.get("o").intValue(), 3);
    }

    @Test
    public void testRemove() {
        MyHashMap map = new MyHashMap();
        map.put("john", 1);
        map.put("zli0111", 2);
        map.remove("john");
        assertEquals(map.get("zli0111").intValue(), 2);
        assertNull(map.get("john"));
    }

}

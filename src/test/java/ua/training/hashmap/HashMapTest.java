package ua.training.hashmap;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * <p> The Test class for Hash Map.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 29.11.2016.
 */
public class HashMapTest {

    private HashMap<String, String> map;

    @Before
    public void setUp() throws Exception {
        map = new HashMap<>();
    }

    @Test
    public void testResize() throws Exception {
        for (int i = 0; i < 10; i++) {
            assertNull(map.put("Key_" + i, "Value_" + i));
        }
        assertEquals(10, map.size());
        for (int i = 10; i < HashMap.DEFAULT_INITIAL_CAPACITY*1000; i++) {
            assertNull(map.put("Key_" + i, "Value_" + i));
        }
        assertEquals(HashMap.DEFAULT_INITIAL_CAPACITY*1000, map.size());
    }

    @Test
    public void testPut() throws Exception {
        for (int i = 0; i < 25; i++) {
            assertNull(map.put("Key_" + i, "Value_" + i));
        }
        for (int i = 0; i < 25; i++) {
            assertEquals("Value_" + i, map.put("Key_" + i, "Value_" + i));
        }
        for (int i = 0; i < 25; i++) {
            assertTrue(map.containsKey("Key_" + i));
            assertTrue(map.containsValue("Value_" + i));
        }
        assertFalse(map.containsKey(null));
        assertNull(map.put(null, "NullValue"));
        assertEquals("NullValue", map.put(null, "NullValue"));
        assertTrue(map.containsKey(null));
        assertFalse(map.containsKey("Any key"));
    }

    @Test
    public void testGet() throws Exception {
        for (int i = 0; i < 25; i++) {
            assertNull(map.put("Key_" + i, "Value_" + i));
        }
        for (int i = 0; i < 25; i++) {
            assertEquals("Value_" + i, map.get("Key_" + i));
        }
        assertNull(map.get("Any key"));
        assertNull(map.get(null));
        map.put(null, "NullValue");
        assertEquals("NullValue", map.get(null));
    }

    @Test
    public void testRemove() throws Exception {
        map.put(null, "NullValue");
        for (int i = 0; i < 25; i++) {
            map.put("Key_" + i, "Value_" + i);
        }
        assertTrue(map.containsKey(null));
        map.remove(null);
        assertNull(map.remove(null));
        assertFalse(map.containsKey(null));
        assertEquals(25, map.size());
        for (int i = 0; i < 25; i++) {
            assertTrue(map.containsKey("Key_" + i));
            assertEquals("Value_" + i, map.remove("Key_" + i));
            assertFalse(map.containsKey("Key_" + i));
            assertEquals(24 - i, map.size());
        }
        assertEquals(null, map.remove("Key_" + 25));
        assertEquals(null, map.remove("Key_" + 20));
        assertEquals(0, map.size());
    }

    @Test
    public void testSize() throws Exception {
        assertEquals(0, map.size());
        for (int i = 0; i < 25; i++) {
            map.put("Key_" + i, "Value_" + i);
        }
        map.put(null, "NullValue");
        assertEquals(26, map.size());
        map.clear();
        assertEquals(0, map.size());
    }

    @Test
    public void testClear() throws Exception {
        map.put(null, "NullValue");
        for (int doubleRun = 0; doubleRun < 2; doubleRun++) {
            for (int i = 0; i < 25; i++) {
                map.put("Key_" + i, "Value_" + i);
            }
            assertEquals(26 - doubleRun, map.size());
            map.clear();
            assertEquals(0, map.size());
            for (int i = 0; i < 25; i++) {
                assertFalse(map.containsKey("Key_" + i));
                assertFalse(map.containsValue("Value_" + i));
            }
        }
    }

    @Test
    public void testContainsKey() throws Exception {
        for (int i = 0; i < 25; i++) {
            assertNull(map.put("Key_" + i, "Value_" + i));
        }
        assertFalse(map.containsKey(null));
        for (int i = 0; i < 25; i++) {
            assertTrue(map.containsKey("Key_" + i));
        }
        assertNull(map.put(null, "NullValue"));
        assertTrue(map.containsKey(null));
        for (int i = 25; i < 50; i++) {
            assertFalse(map.containsKey("Key_" + i));
        }
    }

    @Test
    public void testContainsValue() throws Exception {
        for (int i = 0; i < 25; i++) {
            assertNull(map.put("Key_" + i, "Value_" + i));
        }
        assertFalse(map.containsValue(null));
        assertNull(map.put("Key_" + 25, null));
        assertTrue(map.containsValue(null));
        for (int i = 0; i < 25; i++) {
            assertTrue(map.containsValue("Value_" + i));
        }
        for (int i = 25; i < 50; i++) {
            assertFalse(map.containsValue("Key_" + i));
        }
    }


}
package ua.training.list;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static org.junit.Assert.*;

/**
 * <p> The Test class for Array List.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 20.11.2016.
 */
public class ArrayListTest {

    private ArrayList<String> list;

    @Before
    public void setUp() throws Exception {
        list = new ArrayList<>();
        list.add("a");
        list.add("bb");
        list.add("ccc");
        list.add("dddd");
    }

    @Test
    public void testSize() throws Exception {
        assertEquals("Wrong size", 4, list.size());
        list = new ArrayList<>();
        assertEquals("Wrong size. Empty of list.", 0, list.size());
        list.add(null);
        assertEquals("Wrong size. Added null element.", 1, list.size());
        list.add("abcd");
        assertEquals("Wrong size. Added not null element.", 2, list.size());
    }

    @Test
    public void testIsEmpty() throws Exception {
        assertFalse(list.isEmpty());
        list = new ArrayList<>();
        assertTrue(list.isEmpty());
        list.add(null);
        assertFalse(list.isEmpty());
        list.add("abcd");
        assertFalse(list.isEmpty());
    }

    @Test
    public void testAddAndContains() throws Exception {
        assertTrue(list.contains("a"));
        assertTrue(list.contains("bb"));
        assertTrue(list.contains("dddd"));
        assertFalse(list.contains(null));
        assertFalse(list.contains("safsfdsadf"));
        list = new ArrayList<>();
        assertFalse(list.contains(null));
        assertFalse(list.contains("a"));
        list.add(null);
        assertTrue(list.contains(null));
        list.add("abcd");
        assertTrue(list.contains("abcd"));
        assertFalse(list.contains("a"));
    }

    @Test
    public void testSetAndGet() throws Exception {
        list.set(1, "1111");
        assertEquals("1111", list.get(1));
        assertEquals("a", list.get(0));
        assertEquals("ccc", list.get(2));
        list.set(0, null);
        assertEquals(null, list.get(0));
    }

    @Test
    public void testAdd() {
        int size = list.size();
        list.add("abcd");
        assertEquals("abcd", list.get(size));
        assertEquals(size + 1, list.size());
        size = list.size();
        list.add(null);
        assertEquals(null, list.get(size));
        assertEquals(size + 1, list.size());
        int index = list.size();
        list.add(index, "2222");
        assertEquals("2222", list.get(index));
        assertEquals(index + 1, list.size());
        size = list.size();
        list.add(0, null);
        assertEquals(null, list.get(0));
        assertEquals(size + 1, list.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIllegalArgumentSet() {
        list.set(list.size(), "error");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIllegalArgumentAdd() {
        list.add(list.size() + 1, "error");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testNegativeArgumentSet() {
        list.set(-10, "error");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testNegativeArgumentAdd() {
        list.add(-1, "error");
    }

    @Test
    public void testRemove() throws Exception {
        assertFalse(list.remove("abcd"));
        int size = list.size();
        assertTrue(list.remove("a"));
        assertEquals(size - 1, list.size());
        assertFalse(list.contains("a"));
        size = list.size();
        assertEquals("bb", list.remove(0));
        assertEquals(size - 1, list.size());
        assertFalse(list.contains("bb"));
        size = list.size();
        assertEquals("dddd", list.remove(size - 1));
        assertEquals(size - 1, list.size());
        assertFalse(list.contains("dddd"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveEmpty() throws Exception {
        list = new ArrayList<>();
        list.remove(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveNegativeIndex() throws Exception {
        list.remove(-10);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveIndexMoreThenSize() throws Exception {
        list.remove(list.size() + 1);
    }

    @Test
    public void testExtensibility() {
        for (int i = 0; i < 1000; i++)
            list.add("sdsafdsdg");
        assertEquals(1004, list.size());
        for (int i = 0; i < 1000; i++)
            list.add(0, "sdsafdsdg");
        assertEquals(2004, list.size());
    }
}
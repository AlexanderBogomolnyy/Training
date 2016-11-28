package ua.training.set;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * <p> The Test class for Tree Set.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 28.11.2016.
 */
public class TreeSetTest {

	private TreeSet<String> set = new TreeSet<>();

	@Before
	public void setUp() throws Exception {
		set.add("a");
		set.add("bb");
		set.add("ccc");
		set.add("dddd");
	}

	@Test
	public void testIsEmpty() {
		assertFalse(set.isEmpty());
		set.remove("a");
		set.remove("bb");
		set.remove("ccc");
		set.remove("dddd");
		assertTrue(set.isEmpty());
	}

	@Test
	public void testSize() {
		assertEquals(4, set.size());
		set.remove("a");
		set.remove("bb");
		set.remove("ccc");
		set.remove("dddd");
		assertEquals(0, set.size());
	}

	@Test
	public void testAdd() {
		assertTrue(set.contains("a"));
		assertTrue(set.add("eeeee"));
		assertFalse(set.add("eeeee"));
		assertTrue(set.contains("eeeee"));
		set.remove("a");
		assertFalse(set.contains("a"));
		assertTrue(set.add("aa"));
		assertTrue(set.contains("aa"));
	}
	
	@Test(expected = NullPointerException.class)
	public void testAddNullPointer() {
		set.add(null);
	}
	
	@Test
	public void testContains() {
		assertTrue(set.contains("a"));
		assertFalse(set.contains("eeeee"));
		assertTrue(set.remove("a"));
		assertFalse(set.contains("a"));
		assertTrue(set.contains("dddd"));
	}

	@Test
	public void testRemove() {
		assertTrue(set.contains("a"));
		assertTrue(set.remove("a"));
		assertFalse(set.contains("a"));
		assertFalse(set.remove("a"));
		assertFalse(set.remove("abcd"));
		assertFalse(set.remove(null));
	}
}

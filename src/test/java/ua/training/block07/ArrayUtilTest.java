package ua.training.block07;

import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

/**
 * <p> This class provides test cases for ArrayUtil.class .
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 13.11.2016.
 */
public class ArrayUtilTest {

    private final ArrayUtil util = new ArrayUtil();

    private int[][] first;
    private int[][] second;
    private int[][] sorted;
    private int[][] repeats;
    private int[][] nonRepeats;

    @Before
    public void setUp() throws Exception {
        first = new int[][] {
                {},
                {1},
                {1, 1, 1, 1, 1, 1},
                {1, 2, 3, 4, 5, 6},
                {5 ,2, 4, 1, 6, 0},
                {2, 3, 5, 15, 12, 19, 17, 3, 3, 3, 3, 3, 22, 34, 23, 45}
        };
        second = new int[][] {
                {5 ,2, 4, 1, 6, 0},
                {1, 2, 3, 4, 5, 6},
                {1, 1, 1, 1, 1, 1},
                {1},
                {},
                {1, 5, 3, 9, 12, 17, 3},
        };
        sorted = new int[][] {
                {},
                {1},
                {1, 1, 1, 1, 1, 1},
                {1, 2, 3, 4, 5, 6},
                {0 ,1, 2, 4, 5, 6},
                {2, 3, 3, 3, 3, 3, 3, 5, 12, 15, 17, 19, 22, 23, 34, 45}
        };
        repeats = new int[][] {
                {},
                {1},
                {1},
                {1},
                {},
                {3, 5, 12, 17}
        };
        nonRepeats = new int[][] {
                {0, 1, 2, 4, 5, 6},
                {2, 3, 4, 5, 6},
                {},
                {2, 3, 4, 5, 6},
                {0, 1, 2, 4, 5, 6},
                {1, 2, 9, 15, 19, 22, 23, 34, 45}
        };
    }

    /**
     * Test case for mergeNonEquals(int[], int[]) method
     *
     * @throws Exception - some unexpected exception
     */
    @Test
    public void testMergeNonEquals() throws Exception {
        for(int i = 0; i < first.length; i++) {
            int[] sortedFirst = util.quickSort(first[i]);
            int[] sortedSecond = util.quickSort(second[i]);
            Collection<Integer> repeats = util.mergeNonEquals(sortedFirst, sortedSecond);
            int[] result = new int[repeats.size()];
            int j = 0;
            for (Integer value: repeats) {
                result[j++] = value;
            }
            assertArrayEquals(nonRepeats[i], result);
        }
    }

    /**
     * Test case for mergeEquals(int[], int[]) method
     *
     * @throws Exception - some unexpected exception
     */
    @Test
    public void testMergeEquals() throws Exception {
        for(int i = 0; i < first.length; i++) {
            int[] sortedFirst = util.quickSort(first[i]);
            int[] sortedSecond = util.quickSort(second[i]);
            Collection<Integer> repeats = util.mergeEquals(sortedFirst, sortedSecond);
            int[] result = new int[repeats.size()];
            int j = 0;
            for (Integer value: repeats) {
                result[j++] = value;
            }
            assertArrayEquals(this.repeats[i], result);
        }
    }


    /**
     * Test case for quickSort(int[]) method
     *
     * @throws Exception - some unexpected exception
     */
    @Test
    public void testQuickSort() throws Exception {
        for(int i = 0; i < first.length; i++) {
            assertArrayEquals(sorted[i], util.quickSort(first[i]));
        }
    }
}
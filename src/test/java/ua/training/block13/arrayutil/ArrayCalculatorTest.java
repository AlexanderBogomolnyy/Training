package ua.training.block13.arrayutil;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.*;

/**
 * <p> The test cases for ArrayCalculator class.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 22.12.2016.
 */
public class ArrayCalculatorTest {

    private int[] array;
    private long sum;

    @Test
    public void testRandomIntArrayEqualLength() throws Exception {
        int[] array1 = ArrayCalculator.randomIntArray(10000, 15);
        int[] array2 = ArrayCalculator.randomIntArray(10000, 15);
        assertTrue(array1.length == array2.length);
    }

    @Test
    public void testRandomIntArrayLength() throws Exception {
        int[] array = ArrayCalculator.randomIntArray(10000, 15);
        assertEquals(10000, array.length);
    }

    @Test
    public void testRandomIntArray() throws Exception {
        int[] array = ArrayCalculator.randomIntArray(10000, 15);
        int count = 0;
        for(int i = 0; i < array.length-1; i++) {
            if (array[i] == array[i+1]) {
                count++;
            }
        }
        assertNotEquals(count, array.length - 1);
    }

    // Initialization of test data
    private void initArray() {
        int size = 500;
        array = new int[size];
        IntStream.range(0, size).boxed().forEach(x -> array[x] = x);
        sum = 0;
        for(int i: array) {
            sum += i;
        }
    }

    @Test
    public void testCountSumStream() throws Exception {
        initArray();
        assertEquals(sum, ArrayCalculator.countSum(array, ArrayCalculator.STREAM_SUM));
    }

    @Test
    public void testCountSumStreamParallel() throws Exception {
        initArray();
        assertEquals(sum, ArrayCalculator.countSum(array, ArrayCalculator.STREAM_PARALLEL_SUM));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCountSumCustomParallelException() throws Exception {
        initArray();
        ArrayCalculator.countSum(array, ArrayCalculator.CUSTOM_PARALLEL_SUM);
    }

    @Test
    public void testCountSumCustomParallelMultiThread() throws Exception {
        initArray();
        for(int i = 1; i < 11; i++)
        assertEquals(sum, ArrayCalculator.countSum(array, ArrayCalculator.CUSTOM_PARALLEL_SUM, i));
    }
}
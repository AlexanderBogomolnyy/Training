package ua.training.block07;

import java.util.Arrays;
import java.util.Collection;

/**
 * <p> The main started class.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 13.11.2016.
 */
public class Runner {
    public static void main(String[] args) {
        int arraySecond[] = { 1, 5, 3, 9, 12, 17, 3 };
        int arrayFirst[]  = { 2, 3, 5, 15, 12, 19, 17, 3, 3, 3, 3, 3, 22, 34, 23, 45};

        ArrayUtil util = new ArrayUtil();

        System.out.println("---== Unsorted arrays ==---");
        System.out.println(Arrays.toString(arrayFirst));
        System.out.println(Arrays.toString(arraySecond));
        System.out.println();

        System.out.println("---== Sorted arrays ==---");
        System.out.println(Arrays.toString(util.quickSort(arrayFirst)));
        System.out.println(Arrays.toString(util.quickSort(arraySecond)));
        System.out.println();

        System.out.println("---== Values contain in both arrays (duplicates omitted) ==---");
        Collection<Integer> repeats = util.mergeEquals(util.quickSort(arrayFirst), util.quickSort(arraySecond));
        System.out.println(repeats.toString());
        System.out.println();

        System.out.println("---== Values occurring only once in both arrays ==---");
        Collection<Integer> notRepeats = util.mergeNonEquals(util.quickSort(arrayFirst), util.quickSort(arraySecond));
        System.out.println(notRepeats.toString());
        System.out.println();
    }
}

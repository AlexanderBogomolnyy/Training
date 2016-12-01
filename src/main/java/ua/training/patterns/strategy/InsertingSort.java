package ua.training.patterns.strategy;

import java.util.Arrays;

/**
 * <p> The class implements Sorting interface and provides Inserting sorting algorithm
 * for sorting array of integer values.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 01.12.2016.
 */
public class InsertingSort implements Sorting {

    @Override
    public void sort(int[] array) {
        System.out.println("Inserting sorting");
        System.out.println("before:\t" + Arrays.toString(array));
        for(int barrier = 1; barrier < array.length; barrier++) {
            int index = barrier;
            while(index - 1 >= 0 && array[index] < array[index-1]) {
                int temp = array[index];
                array[index] = array[index-1];
                array[index-1] = temp;
                index--;
            }
        }
        System.out.println("after:\t" + Arrays.toString(array));
    }

}

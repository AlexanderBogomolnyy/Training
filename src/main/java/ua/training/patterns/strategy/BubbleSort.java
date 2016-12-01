package ua.training.patterns.strategy;

import java.util.Arrays;

/**
 * <p> The class implements Sorting interface and provides Bubble sorting algorithm
 * for sorting array of integer values.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 01.12.2016.
 */
public class BubbleSort implements Sorting {

    @Override
    public void sort(int[] array) {
        System.out.println("Bubble sorting");
        System.out.println("before:\t" + Arrays.toString(array));
        for(int barrier = array.length - 1; barrier >= 0; barrier--) {
            for(int i = 0; i < barrier; i++) {
                if (array[i] > array[i+1]) {
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
        }
        System.out.println("after:\t" + Arrays.toString(array));
    }

}

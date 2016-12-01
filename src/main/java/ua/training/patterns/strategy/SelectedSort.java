package ua.training.patterns.strategy;

import java.util.Arrays;

/**
 * <p> The class implements Sorting interface and provides Selected sorting algorithm
 * for sorting array of integer values.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 01.12.2016.
 */
public class SelectedSort implements Sorting {

    @Override
    public void sort(int[] array) {
        System.out.println("Selected sorting");
        System.out.println("before:\t" + Arrays.toString(array));
        for(int barrier = 0; barrier < array.length - 1; barrier++) {
            for (int i = barrier + 1; i < array.length; i++) {
                if (array[i] < array[barrier]) {
                    int temp = array[i];
                    array[i] = array[barrier];
                    array[barrier] = temp;
                }
            }
        }
        System.out.println("after:\t" + Arrays.toString(array));
    }

}

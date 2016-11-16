package ua.training.block07;

import java.util.*;

/**
 * <p> This class provides methods for processing arrays.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 13.11.2016.
 */
public class ArrayUtil {

    /**
     * This method works only with sorted input arrays.
     * It selects non equal elements from two arrays and
     * puts them to the new collection.
     * Duplicated values included into the result collection only once.
     *
     * @param arrayFirst - first sorted array for merge
     * @param arraySecond - second sorted array for marge
     * @return - result collection without repeats
     */
    public Collection<Integer> mergeNonEquals(int[] arrayFirst, int[] arraySecond) {
        Collection<Integer> result = new ArrayList<>();
        int firstIndex = 0;
        int secondIndex = 0;
        while (!(firstIndex >= arrayFirst.length && secondIndex >= arraySecond.length)) {
            while (firstIndex < arrayFirst.length - 1 && arrayFirst[firstIndex] == arrayFirst[firstIndex + 1]) {
                firstIndex++;
            }
            while (secondIndex < arraySecond.length - 1 && arraySecond[secondIndex] == arraySecond[secondIndex + 1]) {
                secondIndex++;
            }
            if(firstIndex < arrayFirst.length && secondIndex < arraySecond.length) {
                if (arrayFirst[firstIndex] != arraySecond[secondIndex]) {
                    if (arrayFirst[firstIndex] < arraySecond[secondIndex]) {
                        result.add(arrayFirst[firstIndex]);
                        firstIndex++;
                    } else {
                        result.add(arraySecond[secondIndex]);
                        secondIndex++;
                    }
                } else {
                    firstIndex++;
                    secondIndex++;
                }
            } else {
                if (firstIndex < arrayFirst.length) {
                    result.add(arrayFirst[firstIndex]);
                    firstIndex++;
                } else if (secondIndex < arraySecond.length){
                    result.add(arraySecond[secondIndex]);
                    secondIndex++;
                } else {
                    firstIndex++;
                    secondIndex++;
                }
            }
        }
        return result;
    }

    /**
     * This method works only with sorted input arrays.
     * It selects equal elements from two arrays and
     * puts them to the new collection.
     * Duplicated values included into the result collection only once.
     *
     * @param arrayFirst - first sorted array for merge
     * @param arraySecond - second sorted array for marge
     * @return - result collection without repeats
     */
    public Collection<Integer> mergeEquals(int[] arrayFirst, int[] arraySecond) {
        Collection<Integer> result = new ArrayList<>();
        int firstIndex = 0;
        int secondIndex = 0;
        while (firstIndex < arrayFirst.length && secondIndex < arraySecond.length) {
            if (arrayFirst[firstIndex] == arraySecond[secondIndex]) {
                int val = arrayFirst[firstIndex];
                result.add(val);
                firstIndex++;
                secondIndex++;
                while (firstIndex < arrayFirst.length && val == arrayFirst[firstIndex]){
                    firstIndex++;
                }
            } else if (arrayFirst[firstIndex] < arraySecond[secondIndex]) {
                firstIndex++;
            } else {
                secondIndex++;
            }
        }
        return result;
    }

    /**
     * This method sorts array of integer values using quick sort algorithm.
     *
     * @param array - array of integer values
     * @return - new sorted array
     */
    public int[] quickSort(int[] array) {
        int[] result = new int[array.length];
        System.arraycopy(array,0,result,0,array.length);
        quickSort(result, 0, result.length-1);
        return result;
    }

    // Recursive part of quick sort algorithm
    private void quickSort(int[] array, int low, int high) {
        if (array == null || array.length == 0) return;
        if (low >= high) return;
        int middle = low + (high - low) / 2;
        int pivot = array[middle];
        int i = low;
        int j = high;
        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j)
            quickSort(array, low, j);
        if (high > i)
            quickSort(array, i, high);
    }

    /**
     * This method processes array of integer values and returns
     * the Map<Integer, Collection<Integer>> in which Key is repeatability of some Integer value
     * and Value is Collection<Integer> contains Integer values repeated Key-times
     *
     * @param array - array of integer values
     * @return - return Map, in which Key is repeatability of some value and
     *           Value is Collection contains values repeated Key-times
     */
    public Map<Integer, Collection<Integer>> collectByRepeatability(int[] array) {
        Map<Integer, Collection<Integer>> result = new TreeMap<>();
        Map<Integer, Integer> selector = new HashMap<>();
        for (Integer integer: array) {
            if(selector.containsKey(integer)) {
                int counter = selector.get(integer);
                selector.put(integer, ++counter);
            } else {
                selector.put(integer, 1);
            }
        }
        for(Map.Entry<Integer,Integer> entry: selector.entrySet()) {
            Collection <Integer> collection;
            if(result.containsKey(entry.getValue())) {
                collection = result.get(entry.getValue());
            } else {
                collection = new TreeSet<>();
                result.put(entry.getValue(), collection);
            }
            collection.add(entry.getKey());
        }
        return result;
    }

}

package ua.training.patterns.iterator;

/**
 * <p> The Iterator pattern sample.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 02.12.2016.
 */
public class IteratorApp {
    public static void main(String[] args) {
        Tasks tasks = new Tasks();
        Iterator iterator = tasks.getIterator();
        while(iterator.hasNext()){
            System.out.println((String)iterator.next());
        }
    }
}

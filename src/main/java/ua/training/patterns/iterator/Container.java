package ua.training.patterns.iterator;

/**
 * <p> The Container interface.
 * This is Aggregate interface from Iterator pattern idiom.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 02.12.2016.
 */
interface Container {
    /**
     * This method returns new iterator for concrete collection
     *
     * @return new iterator
     */
    Iterator getIterator();
}

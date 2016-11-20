package ua.training.patterns.factorymethod;

/**
 * <p> The interface describes abstract WatchMaker.
 * It provides method createWatch(). This method is a factory method.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 18.11.2016.
 */
public interface WatchMaker {
    /**
     * Factory method
     * @return new watch
     */
    Watch createWatch();
}

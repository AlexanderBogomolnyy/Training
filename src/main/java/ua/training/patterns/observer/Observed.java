package ua.training.patterns.observer;

/**
 * <p> The Observed interface.
 * This interface describes object under observation.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 25.11.2016.
 */
interface Observed {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

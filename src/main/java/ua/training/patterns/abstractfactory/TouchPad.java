package ua.training.patterns.abstractfactory;

/**
 * <p> The interface describes Touch pad device behaviour.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 21.11.2016.
 */
public interface TouchPad {
    void track(int deltaX, int deltaY);
}

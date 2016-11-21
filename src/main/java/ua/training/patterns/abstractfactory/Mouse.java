package ua.training.patterns.abstractfactory;

/**
 * <p> The interface describes Mouse device behaviour.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 21.11.2016.
 */
interface Mouse {
    void click();
    void doubleClick();
    void scroll(int direction);
}

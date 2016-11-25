package ua.training.patterns.state;

/**
 * <p> The interface describes some Human activity.
 * This is a State interface from State pattern idiom.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 25.11.2016.
 */
interface Activity {
    void doSomething(Human context);
}

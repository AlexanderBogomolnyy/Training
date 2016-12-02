package ua.training.patterns.flyweight;

/**
 * <p> The interface describes some kind of graphical elements.
 * Elements, which implement this interface, can being drawn.
 * This interface provides Flyweight interface from Flyweight pattern idiom.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 02.12.2016.
 */
interface Shape {
    void draw(int x, int y);
}

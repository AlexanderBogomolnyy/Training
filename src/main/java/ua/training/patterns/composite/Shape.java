package ua.training.patterns.composite;

/**
 * <p> The interface describes some kind of graphical elements.
 * Elements, which implement this interface, can being drawn.
 * This interface provides Component interface for Composite pattern.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 23.11.2016.
 */
interface Shape {
    void draw();
}

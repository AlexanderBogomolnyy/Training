package ua.training.patterns.composite;

/**
 * <p> Implementation of interface Shape for Circle.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 23.11.2016.
 */
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Hello, I am Circle.");
    }
}

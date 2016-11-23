package ua.training.patterns.composite;

/**
 * <p> Implementation of interface Shape for Triangle.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 23.11.2016.
 */
class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Hello, I am Triangle.");
    }
}

package ua.training.patterns.flyweight;

/**
 * <p> The Circle class.
 * This class implements Shape interface.
 * This class represents ConcreteFlyweight from Flyweight pattern idiom
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 02.12.2016.
 */
class Circle implements Shape {

    private int radius = 5;

    @Override
    public void draw(int x, int y) {
        System.out.println("(" + x + "," + y + "): draw circle with radius " + radius);
    }
}

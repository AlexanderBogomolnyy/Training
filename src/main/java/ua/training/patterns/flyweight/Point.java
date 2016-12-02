package ua.training.patterns.flyweight;

/**
 * <p> The Point class.
 * This class implements Shape interface.
 * This class represents ConcreteFlyweight from Flyweight pattern idiom
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 02.12.2016.
 */
class Point implements Shape {

    @Override
    public void draw(int x, int y) {
        System.out.println("(" + x + "," + y + "): draw point");
    }
}

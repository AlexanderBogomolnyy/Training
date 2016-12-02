package ua.training.patterns.flyweight;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * <p> The Flyweight pattern sample.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 02.12.2016.
 */
public class FlyweightApp {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        List<Shape> shapes = new ArrayList<>();

        shapes.add(shapeFactory.getShape("square"));
        shapes.add(shapeFactory.getShape("circle"));
        shapes.add(shapeFactory.getShape("circle"));
        shapes.add(shapeFactory.getShape("point"));
        shapes.add(shapeFactory.getShape("square"));
        shapes.add(shapeFactory.getShape("circle"));

        Random random = new Random();
        for (Shape shape: shapes) {
            int x = random.nextInt(100);
            int y = random.nextInt(100);
            shape.draw(x, y);
        }
    }
}

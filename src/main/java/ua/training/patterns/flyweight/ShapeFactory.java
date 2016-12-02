package ua.training.patterns.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * <p> The Square Factory class.
 * This class represents FlyweightFactory from Flyweight pattern idiom
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 02.12.2016.
 */
public class ShapeFactory {
    private static final Map<String, Shape> shapes = new HashMap<>();

    public Shape getShape(String shapeName) {
        Shape shape = shapes.get(shapeName);
        if (shape==null) {
            switch (shapeName) {
                case "circle":
                    shape = new Circle();
                    break;
                case "square":
                    shape = new Square();
                    break;
                case "point":
                    shape = new Point();
                    break;
            }
            shapes.put(shapeName, shape);
        }
        return shape;
    }

}

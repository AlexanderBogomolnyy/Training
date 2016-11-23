package ua.training.patterns.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> Composite class.
 * It implements interface Shape too.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 23.11.2016.
 */
class Composite implements Shape {
    private List<Shape> components = new ArrayList<>();

    public void addComponent(Shape component) {
        components.add(component);
    }

    public void removeComponent(Shape component) {
        components.remove(component);
    }

    /**
     * This method calls draw method at all components containing in the class.
     * If list of components contains another Composite, this method calls it's method draw()
     * and all components inside another Composite will be drawn by the same manner.
     */
    @Override
    public void draw() {
        for(Shape component: components) {
            component.draw();
        }
    }
}

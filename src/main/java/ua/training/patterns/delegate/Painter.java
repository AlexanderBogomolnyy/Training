package ua.training.patterns.delegate;

/**
 * <p> Painter.class which represents a painter who can draw any kinds of Graphics elements.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 18.11.2016.
 */
public class Painter {

    Graphics graphics;

    /**
     * Mutator method
     *
     * @param graphics - some kind of Graphics
     */
    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }

    /**
     * This method draw some shape using draw() method of class
     * which implements Graphics interface
     */
    void draw() {
        graphics.draw();
    }
}

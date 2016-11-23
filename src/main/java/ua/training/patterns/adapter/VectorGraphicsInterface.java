package ua.training.patterns.adapter;

/**
 * <p> The interface describes some samples of vector graphics.
 * This is the Target interface of Adapter
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 23.11.2016.
 */
interface VectorGraphicsInterface {
    /**
     * This method draw line
     */
    void drawLine();

    /**
     * This method draw square
     */
    void drawSquare();
}

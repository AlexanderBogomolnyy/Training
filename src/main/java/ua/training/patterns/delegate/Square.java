package ua.training.patterns.delegate;

/**
 * <p> Implementation for interface Graphics.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 18.11.2016.
 */
class Square implements Graphics {

    /**
     * This method draw square
     */
    @Override
    public void draw() {
        System.out.println("Draw a square.");
    }
}
